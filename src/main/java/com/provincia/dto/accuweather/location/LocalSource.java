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
public class LocalSource {

    @JsonProperty("Id")
    public int id;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("WeatherCode")
    public String weatherCode;

}
