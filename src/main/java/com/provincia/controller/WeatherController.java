package com.provincia.controller;


import com.provincia.dto.service.WeatherServiceResponseDTO;
import com.provincia.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {


    public final WeatherService weatherService;


    @GetMapping("/{countryCode}")
    public ResponseEntity<WeatherServiceResponseDTO> getActualWeather(@PathVariable("countryCode") Integer countryCode) {

        return new ResponseEntity<>(weatherService.getActualWeather(countryCode), HttpStatus.OK);
    }


}
