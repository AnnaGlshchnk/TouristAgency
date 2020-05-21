package com.anna.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private City city;

    @Column(name = "departure_date", nullable = false)
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    @Column(name = "description", nullable = false)
    private String description;


    @ManyToMany
    @JoinTable(
            name = "user_tour",
            joinColumns = {@JoinColumn(name = "tour_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> users;
}
