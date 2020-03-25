package com.anna.mapping;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {HotelMapper.class, CityWithCountryMapper.class, TransportMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TourMapper {

    @IterableMapping(elementTargetType = TourDto.class)
    Set<TourDto> tourEntityListToTourDtoSet(List<Tour> tours);

    TourDto tourEntityToTourDto(Tour tourEntity);

    TourDetailDto tourEntityToTourDetailDto(Tour tourEntity);

    @Mappings({
            @Mapping(target = "departureCity", ignore = true),
            @Mapping(target = "cities", ignore = true),

    })
    Tour newTourDtoToTourEntity(NewTourDto newTourDto);
}
