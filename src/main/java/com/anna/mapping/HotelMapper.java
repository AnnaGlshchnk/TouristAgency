package com.anna.mapping;

import com.anna.model.dto.HotelDetailDto;
import com.anna.model.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mappings({
            @Mapping(target = "hotelName", source = "hotelEntity.hotelName"),
            @Mapping(target = "countOfStars", source = "hotelEntity.countOfStars"),
            @Mapping(target = "nutrition", source = "hotelEntity.nutrition")
    })
    HotelDetailDto hotelEntityToHotelDetailDto(Hotel hotelEntity);

    @Mappings({
            @Mapping(target = "hotelName", source = "hotelDto.hotelName"),
            @Mapping(target = "countOfStars", source = "hotelDto.countOfStars"),
            @Mapping(target = "nutrition", source = "hotelDto.nutrition")
    })
    Hotel hotelEntityToHotelDetailDto(HotelDetailDto hotelDto);
}
