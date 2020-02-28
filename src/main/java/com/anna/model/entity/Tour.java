package com.anna.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tour {

    @Id
    @GeneratedValue
    @Column(name = "tour_id")
    private Long tourId;

    @Column(name = "tour_name", nullable = false, length = 30)
    private String tourName;

    @ManyToOne
    @JoinColumn(name = "departure_city")
    private City departureCity;

    @ManyToOne
    @JoinColumn(name = "trastort_id")
    private Transport transportType;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "count_of_nights", nullable = false)
    private Integer countOfNights;

    @ManyToMany(mappedBy = "citiesInTour")
    private Set<City> citiesInTour;

    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "tours")
    private List<User> users;
}
