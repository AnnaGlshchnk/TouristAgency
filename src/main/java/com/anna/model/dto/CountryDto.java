package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryDto {

    @NotNull
    @Size(min = 2, max = 40, message = "Country name should be between 2 and 40 characters")
    private String name;

    private List<CityDto> cities;
}
