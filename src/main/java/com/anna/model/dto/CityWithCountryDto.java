package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityWithCountryDto {

    @NotNull
    @Size(min = 2, max = 40, message = "City name should be between 2 and 40 characters")
    private String city;

    @NotNull
    @Size(min = 2, max = 40, message = "Country name should be between 2 and 40 characters")
    private String country;

}
