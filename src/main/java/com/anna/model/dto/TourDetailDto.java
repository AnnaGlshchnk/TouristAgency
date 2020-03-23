package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TourDetailDto {

    private String tourName;
    private CityWithCountryDto departureCity;
    private TransportDto transportType;
    private Integer price;
    private Integer countOfNights;
    private CityWithCountryDto cities;
    private Date departureDate;
    private HotelDetailDto hotel;
    private String description;
}
