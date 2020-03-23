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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
