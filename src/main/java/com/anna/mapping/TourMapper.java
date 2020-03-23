package com.anna.mapping;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {HotelMapper.class, CityWithCountryMapper.class, TransportMapper.class})
public interface TourMapper {

    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);

    @IterableMapping(elementTargetType = TourDto.class)
    Set<TourDto> tourEntityListToTourDtoSet(List<Tour> tours);

    TourDto tourEntityToTourDto(Tour tourEntity);

    TourDetailDto tourEntityToTourDetailDto(Tour tourEntity);

    Tour newTourDtoToTourEntity(NewTourDto newTourDto);
}
