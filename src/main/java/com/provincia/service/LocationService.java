package com.provincia.service;


import com.provincia.Exception.RestException;
import com.provincia.dto.accuweather.location.LocationResponse;
import com.provincia.dto.location.CountryDto;
import com.provincia.dto.location.LocationDTO;
import com.provincia.model.CountryModel;
import com.provincia.model.LocationModel;
import com.provincia.repository.ICountryRepository;
import com.provincia.repository.ILocationRepository;
import com.provincia.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LocationService {

    @Value("${spring.external.location.service.base-url}")
    private String baseUrl;

    @Value("${spring.external.service.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ILocationRepository locationRepository;
    private final ICountryRepository countryRepository;


    public List<CountryDto> getLocations(String query) throws RestException {

        List<CountryModel> countryModelList = countryRepository.findAll();
        List<CountryDto> countryDtoList = new ArrayList<>();
        Mapper mapper = new Mapper();


        if(countryModelList.isEmpty()) {


            Map<String, Object> uriVariables = new HashMap<>();
            uriVariables.put("query", query);
            uriVariables.put("apikey", apiKey);
            uriVariables.put("offset", 50);

            ResponseEntity<LocationResponse[]> serviceResponse = restTemplate.getForEntity(baseUrl, LocationResponse[].class, uriVariables);

            //si la respuesta del servicio no devuelve registros. lanzo una exception personalizada

            if (serviceResponse.getBody() != null) {

                List<LocationResponse> locationResponseList = Arrays.asList(serviceResponse.getBody());
                //mapeo una lista de la entidad location con la respuesta del servicio para posteriormente guardar esos registros en la base de datos


                locationResponseList.stream().forEach((locationResponse -> mapper.mapLocationResponseToModel(locationResponse, countryModelList)));
                System.out.println(countryModelList);
                countryRepository.saveAll(countryModelList);

                countryRepository.findAll().stream().forEach(countryModel -> mapper.mapLocationModelToDTO(countryModel, countryDtoList));

            } else {

                throw new RestException(401, "Accuweather service did not return any data");

            }

        }
        countryModelList.stream().forEach(countryModel -> mapper.mapLocationModelToDTO(countryModel, countryDtoList));
        return countryDtoList;
    }

}
