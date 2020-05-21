package com.anna.mapping;

import com.anna.model.dto.CountryDto;
import com.anna.model.entity.Country;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = CityMapper.class)
public interface CountryMapper {

    @IterableMapping(elementTargetType = CountryDto.class)
    Set<CountryDto> countriesToCountryDtoSet(List<Country> countries);

    CountryDto countryEntityToCountryDto(Country countryEntity);

    Country countryDtoToCountryEntity(CountryDto countryDto);

}
