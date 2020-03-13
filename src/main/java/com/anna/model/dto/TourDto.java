package com.anna.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TourDto {

    private String name;
    private Integer price;
    private String country;
    private String city;
    private String description;
}
