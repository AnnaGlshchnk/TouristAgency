package com.anna.mapping;

import com.anna.model.dto.CityDto;
import com.anna.model.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDto cityEntityToCityDto(City cityEntity);

    City cityDtoToCityEntity(CityDto cityDto);
}
