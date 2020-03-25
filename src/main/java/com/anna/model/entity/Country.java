package com.anna.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity()
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "country_name", nullable = false, unique = true, length = 40)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> cities;
}
