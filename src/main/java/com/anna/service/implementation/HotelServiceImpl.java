package com.anna.service.implementation;

import com.anna.mapping.HotelMapper;
import com.anna.model.dto.HotelDetailDto;
import com.anna.model.entity.Hotel;
import com.anna.repository.HotelRepository;
import com.anna.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Override
    public Set<HotelDetailDto> findAllHotel() {
        List<Hotel> hotelsFromDB = hotelRepository.findAll();
        Set<HotelDetailDto> hotels = new HashSet<>();
        hotelsFromDB.forEach(hotel -> {
            hotels.add(HotelMapper.INSTANCE.hotelEntityToHotelDetailDto(hotel));
        });

        return hotels;
    }

    @Override
    public void addNewHotel(HotelDetailDto hotelDetailDto) {
        hotelRepository.save(HotelMapper.INSTANCE.hotelEntityToHotelDetailDto(hotelDetailDto));
    }
}
