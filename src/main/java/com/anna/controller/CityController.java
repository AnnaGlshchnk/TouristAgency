package com.anna.controller;

import com.anna.model.dto.CityWithCountryDto;
import com.anna.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class CityController {

    private CityService cityService;

    @GetMapping(path = "/cities")
    public ResponseEntity<Set<CityWithCountryDto>> findAllCities() {
        return ResponseEntity.ok().body(cityService.findAllCityWithCountries());
    }

    @PostMapping(path = "/cities")
    public ResponseEntity<String> addNewHCity(@Valid @RequestBody CityWithCountryDto cityWithCountryDto) {
        cityService.addNewCity(cityWithCountryDto);
        return ResponseEntity.ok().body("new city " + cityWithCountryDto.getCity() + " has added to the system");
    }
}
