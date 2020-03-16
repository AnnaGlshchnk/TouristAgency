package com.anna.mapping;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
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

    @Mappings({
            @Mapping(target = "name", source = "tourEntity.tourName"),
            @Mapping(target = "departureCity", source = "tourEntity.departureCity.name"),
            @Mapping(target = "transportType", source = "tourEntity.transportType.transportType"),
            @Mapping(target = "price", source = "tourEntity.price"),
            @Mapping(target = "countsOfNights", source = "tourEntity.countOfNights"),
            @Mapping(target = "country", source = "tourEntity.cities.country.name"),
            @Mapping(target = "city", source = "tourEntity.cities.name"),
            @Mapping(target = "departureDate", source = "tourEntity.departureDate"),
            @Mapping(target = "hotel.hotelName", source = "tourEntity.hotel.hotelName"),
            @Mapping(target = "hotel.countOfStars", source = "tourEntity.hotel.countOfStars"),
            @Mapping(target = "hotel.nutrition", source = "tourEntity.hotel.nutrition"),
            @Mapping(target = "description", source = "tourEntity.description")
    })
    TourDetailDto tourEntityToTourDetailDto(Tour tourEntity);

    @Mappings({
            @Mapping(target = "tourName", source = "newTourDto.name"),
            @Mapping(target = "departureCity.name", source = "newTourDto.departureCity"),
            @Mapping(target = "transportType.transportType", source = "newTourDto.transportType"),
            @Mapping(target = "price", source = "newTourDto.price"),
            @Mapping(target = "countOfNights", source = "newTourDto.countsOfNights"),
            @Mapping(target = "cities.name", source = "newTourDto.city"),
            @Mapping(target = "departureDate", source = "newTourDto.departureDate"),
            @Mapping(target = "hotel.hotelName", source = "newTourDto.hotel"),
            @Mapping(target = "description", source = "newTourDto.description")
    })
    Tour newTourDtoToTourEntity(NewTourDto newTourDto);
}
