package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TourDto {

    private String tourName;
    private Integer price;
    private String country;
    private CityDto city;
    private String description;
}
