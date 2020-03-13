package com.anna.mapping;

import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TourMapper {

    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "tourEntity.tourName"),
            @Mapping(target = "price", source = "tourEntity.price"),
            @Mapping(target = "country", source = "tourEntity.cities.country.name"),
            @Mapping(target = "city", source = "tourEntity.cities.name"),
            @Mapping(target = "description", source = "tourEntity.description")
    })
    TourDto tourEntityToTourDto(Tour tourEntity);
}
