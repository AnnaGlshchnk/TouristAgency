package com.anna.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "hotel_name", nullable = false, length = 30)
    private String hotelName;

    @Column(name = "count_of_stars", nullable = false)
    private Integer countOfStars;

    @Column(name = "nutrition", nullable = false, length = 5)
    private String nutrition;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tour> tours;
}
