package com.provincia.service;


import com.provincia.dto.service.WeatherServiceResponseDTO;
import com.provincia.model.WeatherModel;
import com.provincia.repository.IWeatherRepository;
import com.provincia.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {


    @Value("${spring.external.weather.service.base-url}")
    private String baseUrl;

    @Value("${spring.external.service.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final IWeatherRepository weatherRepository;


    public WeatherServiceResponseDTO getActualWeather(Integer countryCode){


        Mapper mapper = new Mapper();
        WeatherModel weatherModel = new WeatherModel();

        //si el clima actual que ya se busco anteriormente para el codigo de pais solicitado se obtiene directamente de la base
        //de lo contrario, se consume el servicio de accuweather, se obtiene la informacion y se impacta en la base
        //para limitar el consumo del servicio externo.

        if (!weatherRepository.existsByCountryCode(countryCode)) {

            Map<String, Object> uriVariables = new HashMap<>();
            uriVariables.put("countryCode", String.valueOf(countryCode));
            uriVariables.put("apikey", apiKey);

            ResponseEntity<com.provincia.dto.accuweather.weather.WeatherServiceResponseDTO[]> response = restTemplate.getForEntity(baseUrl, com.provincia.dto.accuweather.weather.WeatherServiceResponseDTO[].class, uriVariables);
            List<com.provincia.dto.accuweather.weather.WeatherServiceResponseDTO> weatherServiceResponseList = Arrays.asList(response.getBody());


            //dado que se que el servicio va a retornar solo un elemento, tomo el primer objeto de la lista y hago el mapeo correspondiente para guardar
            //la entidad en la base de datos
            mapper.mapWeatherDtoToModel(weatherServiceResponseList.get(0),weatherModel, countryCode);
            weatherRepository.save(weatherModel);

        }

        WeatherServiceResponseDTO serviceResponseDTO = new WeatherServiceResponseDTO();
        mapper.mapResponseDtoFromModel(weatherRepository.findByCountryCode(countryCode),serviceResponseDTO);

        return serviceResponseDTO;

        }


}
