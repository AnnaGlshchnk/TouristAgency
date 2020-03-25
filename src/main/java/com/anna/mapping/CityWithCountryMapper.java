package com.anna.mapping;

import com.anna.model.dto.CityWithCountryDto;
import com.anna.model.entity.City;
import com.anna.model.entity.Country;
import org.mapstruct.AfterMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CityWithCountryMapper {

    @IterableMapping(elementTargetType = CityWithCountryDto.class)
    Set<CityWithCountryDto> cityEntityListToCityWithCountryDtoSet(List<City> cityEntity);

    @Mappings({
            @Mapping(target = "city", source = "cityEntity.name"),
            @Mapping(target = "country", source = "cityEntity.country.name")

    })
    CityWithCountryDto cityEntityToCityWithCountryDto(City cityEntity);

    @Mappings({
            @Mapping(target = "name", source = "city.city"),
            @Mapping(target = "country.name", source = "city.country")

    })
    City cityWithCountryDtoToCityEntity(CityWithCountryDto city);

    @Mappings({
            @Mapping(target = "name", source = "city.country"),
            @Mapping(target = "cities", ignore = true)
    })
    void mapCityWithCountryDtoToCountryEntity(CityWithCountryDto city, @MappingTarget Country country);

    @AfterMapping
    default void handleCities(CityWithCountryDto dto, @MappingTarget Country country) {
        City city = cityWithCountryDtoToCityEntity(dto);
        city.setCountry(country);
        country.setCities(Collections.singletonList(city));
    }
}
