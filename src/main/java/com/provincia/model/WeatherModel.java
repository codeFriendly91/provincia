package com.provincia.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "weather")
public class WeatherModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer countryCode;

    private String localObservationDateTime;

    private String weatherText;

    private boolean hasPrecipitation;

    private String precipitationType;

    private Double temperature;


}
