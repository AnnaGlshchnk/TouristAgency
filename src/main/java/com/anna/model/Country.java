package com.anna.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "country_name", nullable = false, unique = true, length = 40)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.LAZY)
    private Set<City> cities;
}
