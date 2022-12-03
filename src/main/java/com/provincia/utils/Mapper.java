package com.provincia.utils;

import com.provincia.dto.accuweather.location.LocationResponse;
import com.provincia.dto.location.CountryDto;
import com.provincia.dto.location.LocationDTO;
import com.provincia.dto.service.WeatherServiceResponseDTO;
import com.provincia.model.CountryModel;
import com.provincia.model.LocationModel;
import com.provincia.model.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class Mapper {


    /**
     * Mapea el modelo del clima con los datos del dto obtenido de la respuesta del servicio de accuweather
     * @param weatherServiceResponseDTO
     * @param weatherModel
     * @param countryCode
     */

    public void mapWeatherDtoToModel(com.provincia.dto.accuweather.weather.WeatherServiceResponseDTO weatherServiceResponseDTO, WeatherModel weatherModel, Integer countryCode){

        weatherModel.setWeatherText(weatherServiceResponseDTO.getWeatherText());
        weatherModel.setTemperature(weatherServiceResponseDTO.getTemperature().getMetric().getValue());
        weatherModel.setLocalObservationDateTime(weatherServiceResponseDTO.getLocalObservationDateTime());
        weatherModel.setCountryCode(countryCode);
        weatherModel.setHasPrecipitation(weatherServiceResponseDTO.hasPrecipitation);
        weatherModel.setPrecipitationType(weatherServiceResponseDTO.getPrecipitationType());
    }


    /**
     * Mapea el dto del clima con los datos del modelo obtenido desde la base de datos
     * @param weatherModel
     * @param serviceResponseDTO
     */

    public void mapResponseDtoFromModel(WeatherModel weatherModel, WeatherServiceResponseDTO serviceResponseDTO){

        serviceResponseDTO.setTemperature(weatherModel.getTemperature());
        serviceResponseDTO.setCountryCode(weatherModel.getCountryCode());
        serviceResponseDTO.setLocalObservationDateTime(weatherModel.getLocalObservationDateTime());
        serviceResponseDTO.setWeatherText(weatherModel.getWeatherText());



    }


    /**
     * mapea un objeto modelo de locacion con la respuesta obtenida del servicio de accuweather y lo mete es una lista
     *
     * @param locationResponse
     * @param countryModelList
     */

    public void mapLocationResponseToModel(LocationResponse locationResponse, List<CountryModel> countryModelList){
        CountryModel countryModel = new CountryModel();
        countryModel.setLocationModel(new ArrayList<>());
        countryModel.setCountryCode(locationResponse.getCountry().getID());
        countryModel.setCountryName(locationResponse.getCountry().getEnglishName());

        LocationModel locationModel = new LocationModel();
        locationModel.setLocationKey(Long.valueOf(locationResponse.getKey()));
        locationModel.setLocalizedName(locationResponse.getLocalizedName());

        countryModel.getLocationModel().add(locationModel);
        countryModelList.add(countryModel);

    }

    /**
     * mapea un objeto LocationDto con los datos de un modelo obtenido de la base de datos y luego
     * lo inserta en una lista
     * @param countryModel
     * @param countryDtoList
     */
    public void mapLocationModelToDTO(CountryModel countryModel, List<CountryDto> countryDtoList){

        CountryDto countryDto = new CountryDto();
        countryDto.setLocationDTOList(new ArrayList<>());

        countryDto.setCountryCode(countryModel.getCountryCode());
        countryDto.setCountryName(countryModel.getCountryName());

        for (LocationModel locationModel: countryModel.getLocationModel()) {

            LocationDTO locationDTO = new LocationDTO();
            locationDTO.setLocationKey(locationModel.getLocationKey());
            locationDTO.setLocalizedName(locationModel.getLocalizedName());
            countryDto.getLocationDTOList().add(locationDTO);
        }


        countryDtoList.add(countryDto);
    }


}
