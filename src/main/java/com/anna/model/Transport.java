package com.anna.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transport {

    @Id
    @GeneratedValue
    @Column(name = "transport_id")
    private Long transportId;

    @Column(name = "type", nullable = false, length = 15)
    private String transportType;

    @OneToMany(mappedBy = "transportType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tour> tours;
}
