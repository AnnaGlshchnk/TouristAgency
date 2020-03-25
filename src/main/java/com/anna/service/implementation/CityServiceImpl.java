package com.anna.service.implementation;

import com.anna.mapping.CityWithCountryMapper;
import com.anna.model.dto.CityWithCountryDto;
import com.anna.model.entity.City;
import com.anna.model.entity.Country;
import com.anna.repository.CityRepository;
import com.anna.repository.CountryRepository;
import com.anna.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CityWithCountryMapper cityWithCountryMapper;

    @Override
    public Set<CityWithCountryDto> findAllCityWithCountries() {
        List<City> citiesFromDB = cityRepository.findAll();
        return cityWithCountryMapper.cityEntityListToCityWithCountryDtoSet(citiesFromDB);
    }

    @Override
    public void addNewCity(CityWithCountryDto cityWithCountryDto) {
        Country country = new Country();
        cityWithCountryMapper.mapCityWithCountryDtoToCountryEntity(cityWithCountryDto, country);
        countryRepository.save(country);
    }
}
