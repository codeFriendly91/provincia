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
public class LocationResponse {

    @JsonProperty("Key")
    public String key;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("Country")
    public Country country;
    @JsonProperty("TimeZone")
    public TimeZone timeZone;
    @JsonProperty("GeoPosition")
    public GeoPosition geoPosition;
    @JsonProperty("LocalObservationDateTime")
    public String localObservationDateTime;
    @JsonProperty("EpochTime")
    public int epochTime;
    @JsonProperty("WeatherText")
    public String weatherText;
    @JsonProperty("WeatherIcon")
    public int weatherIcon;
    @JsonProperty("HasPrecipitation")
    public boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    public String precipitationType;
    @JsonProperty("IsDayTime")
    public boolean isDayTime;
    @JsonProperty("Temperature")
    public Temperature temperature;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;
    @JsonProperty("LocalSource")
    public LocalSource localSource;

}
