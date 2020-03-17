package com.anna.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_tour")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;
}
