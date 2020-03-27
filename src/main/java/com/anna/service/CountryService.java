package com.anna.service;

import com.anna.model.dto.CountryDto;

import java.util.Set;

public interface CountryService {

    Set<CountryDto> findAllCountries();

    void addNewCountry(CountryDto countryDto);
}
