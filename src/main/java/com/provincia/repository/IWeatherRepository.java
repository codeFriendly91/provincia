package com.provincia.repository;


import com.provincia.model.WeatherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IWeatherRepository extends JpaRepository <WeatherModel,Long> {


    WeatherModel findByCountryCode(int countryCode);
    boolean existsByCountryCode(int countryCode);


}
