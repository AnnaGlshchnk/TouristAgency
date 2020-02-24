package com.anna.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city_name", nullable = false, length = 40)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departureCity", fetch = FetchType.LAZY)
    private List<Tour> tours;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tour_city",
            joinColumns = {@JoinColumn(name = "tour_id")},
            inverseJoinColumns = {@JoinColumn(name = "city_id")}
    )
    private Set<Tour> citiesInTour;
}
