package com.anna.controller;

import com.anna.model.dto.HotelDetailDto;
import com.anna.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class HotelController {

    private final HotelService hotelService;

    @GetMapping(path = "/hotels")
    public ResponseEntity<Set<HotelDetailDto>> findAllHotel() {
        return ResponseEntity.ok().body(hotelService.findAllHotel());
    }

    @PostMapping(path = "/hotels")
    public ResponseEntity<String> addNewHotel(@Valid @RequestBody HotelDetailDto hotelDetailDto) {
        hotelService.addNewHotel(hotelDetailDto);
        return ResponseEntity.ok().body("new hotel " + hotelDetailDto.getHotelName() + " has added to the system");
    }
}
