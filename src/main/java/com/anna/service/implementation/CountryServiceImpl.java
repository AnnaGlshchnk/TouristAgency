package com.anna.service.implementation;

import com.anna.mapping.CountryMapper;
import com.anna.model.dto.CountryDto;
import com.anna.model.entity.Country;
import com.anna.repository.CountryRepository;
import com.anna.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public Set<CountryDto> findAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.countriesToCountryDtoSet(countries);
    }

    @Override
    public void addNewCountry(CountryDto countryDto) {
        Country country = countryMapper.countryDtoToCountryEntity(countryDto);
        country.getCities().forEach(city -> city.setCountry(country));
        countryRepository.save(country);
    }
}
