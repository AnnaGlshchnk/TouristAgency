package com.anna.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewTourDto {

    @NotNull(message = "The tour's name shouldn't be empty")
    @Size(min = 2, max = 30, message = "Tour's name should be between 2 and 30 characters")
    private String name;

    @NotNull(message = "Departure city shouldn't be empty")
    @Size(min = 2, max = 40, message = "Departure city should be between 2 and 40 characters")
    private String departureCity;

    @NotNull(message = "Transport type shouldn't be empty")
    @Size(min = 2, max = 15, message = "Transport type should be between 2 and 15 characters")
    private String transportType;

    @NotNull(message = "Price shouldn't be empty")
    @Min(0)
    private Integer price;

    @NotNull(message = "Counts of nights shouldn't be empty")
    @Min(0)
    private Integer countsOfNights;

    @NotNull(message = "City shouldn't be empty")
    @Size(min = 2, max = 40, message = "City should be between 2 and 40 characters")
    private String city;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departureDate;

    @NotNull(message = "Hotel shouldn't be empty")
    @Size(min = 2, max = 30, message = "Hotel should be between 2 and 30 characters")
    private String hotel;

    @NotNull(message = "Description shouldn't be empty")
    @Size(min = 2, message = "Hotel should be more than 2 characters")
    private String description;
}
