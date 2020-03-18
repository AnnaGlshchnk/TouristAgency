package com.anna.service.implementation;

import com.anna.mapping.CityWithCountryMapper;
import com.anna.model.dto.CityWithCountryDto;
import com.anna.model.entity.City;
import com.anna.repository.CityRepository;
import com.anna.repository.CountryRepository;
import com.anna.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    @Override
    public Set<CityWithCountryDto> findAllCityWithCountries() {
        List<City> citiesFromDB = cityRepository.findAll();
        Set<CityWithCountryDto> cities = new HashSet<>();
        citiesFromDB.forEach(city -> {
            cities.add(CityWithCountryMapper.INSTANCE.cityEntityToCityWithCountryDto(city));
        });
        return cities;
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
