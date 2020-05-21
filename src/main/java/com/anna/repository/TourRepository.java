package com.anna.repository;

import com.anna.model.entity.City;
import com.anna.model.entity.Tour;
import com.anna.model.entity.Transport;
import com.anna.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findToursByUsers(User user);

    List<Tour> findToursByCity(City city);

    List<Tour> findToursByTransportType(Transport transport);

    List<Tour> findByCityAndTransportType(City city, Transport transport);
}
