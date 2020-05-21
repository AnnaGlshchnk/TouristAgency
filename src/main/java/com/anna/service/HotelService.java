package com.anna.service;

import com.anna.model.dto.HotelDetailDto;

import java.util.Set;

public interface HotelService {

    Set<HotelDetailDto> findAllHotel();

    void addNewHotel(HotelDetailDto hotelDetailDto);
}
