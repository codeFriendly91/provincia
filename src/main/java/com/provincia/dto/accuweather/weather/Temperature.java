package com.provincia.dto.accuweather.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Temperature {

    @JsonProperty("Metric")
    public Metric metric;
    @JsonProperty("Imperial")
    public Imperial imperial;

}
