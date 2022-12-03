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
public class TimeZone {

    @JsonProperty("Code")
    public String code;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("GmtOffset")
    public double gmtOffset;
    @JsonProperty("IsDaylightSaving")
    public boolean isDaylightSaving;
    @JsonProperty("NextOffsetChange")
    public String nextOffsetChange;

}
