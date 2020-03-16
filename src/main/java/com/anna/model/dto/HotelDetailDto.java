package com.anna.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HotelDetailDto {

    private String hotelName;
    private Integer countOfStars;
    private String nutrition;
}
