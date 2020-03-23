package com.anna.service.implementation;

import com.anna.mapping.CityWithCountryMapper;
import com.anna.model.dto.CityWithCountryDto;
import com.anna.model.entity.City;
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

    @Override
    public Set<CityWithCountryDto> findAllCityWithCountries() {
        List<City> citiesFromDB = cityRepository.findAll();
        return CityWithCountryMapper.INSTANCE.cityEntityListToCityWithCountryDtoSet(citiesFromDB);
    }

    @Override
    public void addNewCity(CityWithCountryDto cityWithCountryDto) {

        City city = CityWithCountryMapper.INSTANCE.cityWithCountryDtoToCityEntity(cityWithCountryDto);
        if (!countryRepository.findByName(cityWithCountryDto.getCountry()).isPresent()) {
            countryRepository.save(CityWithCountryMapper.INSTANCE.cityWithCountryDtoToCountryEntity(cityWithCountryDto));
        }
        city.setCountry(countryRepository.findByName(cityWithCountryDto.getCountry()).get());
        cityRepository.save(city);
    }
}
