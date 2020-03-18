package com.anna.controller;

import com.anna.model.dto.HotelDetailDto;
import com.anna.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class HotelController {

    private HotelService hotelService;

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
