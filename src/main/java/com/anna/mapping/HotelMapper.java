package com.anna.mapping;

import com.anna.model.dto.HotelDetailDto;
import com.anna.model.entity.Hotel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @IterableMapping(elementTargetType = HotelDetailDto.class)
    Set<HotelDetailDto> hotelEntityListToHotelDetailDtoSet(List<Hotel> hotels);

    HotelDetailDto hotelEntityToHotelDetailDto(Hotel hotelEntity);

    Hotel hotelEntityToHotelDetailDto(HotelDetailDto hotelDto);
}
