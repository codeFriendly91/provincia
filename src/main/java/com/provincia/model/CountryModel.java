package com.provincia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "country")
public class CountryModel {

    @Id
    private String countryCode;

    private String countryName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LocationModel> locationModel;


}
