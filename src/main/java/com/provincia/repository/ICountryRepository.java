package com.provincia.repository;

import com.provincia.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository <CountryModel,Long> {
}
