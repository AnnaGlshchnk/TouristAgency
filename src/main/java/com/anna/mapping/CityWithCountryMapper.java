package com.anna.mapping;

import com.anna.model.dto.CityWithCountryDto;
import com.anna.model.entity.City;
import com.anna.model.entity.Country;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CityWithCountryMapper {

    CityWithCountryMapper INSTANCE = Mappers.getMapper(CityWithCountryMapper.class);

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
            @Mapping(target = "name", source = "city.country")
    })
    Country cityWithCountryDtoToCountryEntity(CityWithCountryDto city);
}
