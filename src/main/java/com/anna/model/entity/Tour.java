package com.anna.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tours")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private Long tourId;

    @Column(name = "tour_name", nullable = false, length = 30)
    private String tourName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_city")
    private City departureCity;

    @ManyToOne
    @JoinColumn(name = "transport_type")
    private Transport transportType;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "count_of_nights", nullable = false)
    private Integer countOfNights;

    @ManyToOne
    @JoinColumn(name = "cities")
    private City cities;

    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "tours")
    private List<User> users;
}
