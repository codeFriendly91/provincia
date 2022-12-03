package com.provincia.dto.accuweather.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GeoPosition {

    @JsonProperty("Latitude")
    public double latitude;
    @JsonProperty("Longitude")
    public double longitude;
    @JsonProperty("Elevation")
    public Elevation elevation;
}
