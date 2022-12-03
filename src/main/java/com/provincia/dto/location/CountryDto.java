package com.provincia.dto.location;

import com.provincia.model.LocationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CountryDto {

    private String countryCode;

    private String countryName;

    private List<LocationDTO> locationDTOList;

}
