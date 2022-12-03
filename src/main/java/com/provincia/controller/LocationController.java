package com.provincia.controller;


import com.provincia.Exception.RestException;
import com.provincia.dto.location.CountryDto;
import com.provincia.dto.location.LocationDTO;
import com.provincia.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@RequiredArgsConstructor
public class LocationController {


    public final LocationService locationService;


    @GetMapping("/getLocations")
    public ResponseEntity<List<CountryDto>> getLocations(@RequestParam (required = true, name = "q") String query) throws RestException {

            return new ResponseEntity<>(locationService.getLocations(query), HttpStatus.OK);
    }

}
