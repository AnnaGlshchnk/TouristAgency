package com.anna.repository;

import com.anna.model.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport, Long> {

    Optional<Transport> findByTransportType(String type);
}
