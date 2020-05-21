package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HotelDetailDto {

    @NotNull
    @Size(min = 2, max = 30, message = "Hotel's name should be between 2 and 30 characters")
    private String hotelName;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer countOfStars;

    @NotNull
    @Size(min = 2, max = 5, message = "Nutrition should be between 2 and 5 characters")
    private String nutrition;
}
