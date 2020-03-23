package com.anna.controller;

import com.anna.model.dto.CityWithCountryDto;
import com.anna.service.CityService;
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
public class CityController {

    private final CityService cityService;

    @GetMapping(path = "/cities")
    public ResponseEntity<Set<CityWithCountryDto>> findAllCities() {
        return ResponseEntity.ok().body(cityService.findAllCityWithCountries());
    }

    @PostMapping(path = "/cities")
    public ResponseEntity<String> addNewHCity(@Valid @RequestBody CityWithCountryDto cityWithCountryDto) {
        cityService.addNewCity(cityWithCountryDto);
        return ResponseEntity.ok().body("new city " + cityWithCountryDto.getCity() + " has been added to the system");
    }
}
