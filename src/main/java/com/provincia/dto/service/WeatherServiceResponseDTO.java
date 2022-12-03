package com.provincia.dto.service;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class WeatherServiceResponseDTO {

    private Integer countryCode;

    private String localObservationDateTime;

    private String weatherText;

    private Double temperature;

    private boolean hasPrecipitation;

    private String precipitationType;

}
