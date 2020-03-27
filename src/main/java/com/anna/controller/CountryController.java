package com.anna.controller;

import com.anna.model.dto.CountryDto;
import com.anna.service.CountryService;
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
public class CountryController {

    private final CountryService countryService;

    @GetMapping(path = "/countries")
    public ResponseEntity<Set<CountryDto>> findAllCountries() {
        return ResponseEntity.ok().body(countryService.findAllCountries());
    }

    @PostMapping(path = "/countries")
    public ResponseEntity<String> addNewCity(@Valid @RequestBody CountryDto countryDto) {
        countryService.addNewCountry(countryDto);
        return ResponseEntity.ok().body("new country " + countryDto.getName() + " has been added to the system");
    }
}
