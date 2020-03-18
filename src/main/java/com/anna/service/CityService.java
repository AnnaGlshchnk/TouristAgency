package com.anna.service;

import com.anna.model.dto.CityWithCountryDto;

import java.util.Set;

public interface CityService {

    Set<CityWithCountryDto> findAllCityWithCountries();

    void addNewCity(CityWithCountryDto cityWithCountryDto);
}
