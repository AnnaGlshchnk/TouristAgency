package com.anna.service.implementation;

import com.anna.mapping.HotelMapper;
import com.anna.model.dto.HotelDetailDto;
import com.anna.model.entity.Hotel;
import com.anna.repository.HotelRepository;
import com.anna.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Set<HotelDetailDto> findAllHotel() {
        List<Hotel> hotelsFromDB = hotelRepository.findAll();
        return (HotelMapper.INSTANCE.hotelEntityListToHotelDetailDtoSet(hotelsFromDB));
    }

    @Override
    public void addNewHotel(HotelDetailDto hotelDetailDto) {
        hotelRepository.save(HotelMapper.INSTANCE.hotelEntityToHotelDetailDto(hotelDetailDto));
    }
}
