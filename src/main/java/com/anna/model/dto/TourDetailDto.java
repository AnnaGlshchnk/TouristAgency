package com.anna.model.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TourDetailDto {

    private String name;
    private String departureCity;
    private String transportType;
    private Integer price;
    private Integer countsOfNights;
    private String country;
    private String city;
    private Date departureDate;
    private HotelDetailDto hotel;
    private String description;
}
