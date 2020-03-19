package com.anna.repository;

import com.anna.model.entity.City;
import com.anna.model.entity.Tour;
import com.anna.model.entity.Transport;
import com.anna.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TourRepository extends JpaRepository<Tour, Long> {

    Set<Tour> findToursByUsers(User user);

    Set<Tour> findToursByCities(City city);

    Set<Tour> findToursByTransportType(Transport transport);

    Set<Tour> findByCitiesAndTransportType(City city, Transport transport);
}
