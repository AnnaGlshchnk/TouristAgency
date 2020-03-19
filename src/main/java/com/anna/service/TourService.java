package com.anna.service;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;

import java.util.Set;

public interface TourService {

    Set<TourDto> findAllTours();

    TourDetailDto findTourById(Long id);

    void addNewTour(NewTourDto newTour);

    void deleteTour(Long id);

    void addTourToUserList(String email, Long id);

    void deleteTourFromUserList(String email, Long id);

    Set<TourDto> findFavoriteTours(String email);

    Set<TourDto> findToursByCities(String city);

    Set<TourDto> sortTours();

    Set<TourDto> findToursByTransport(String transport);

    Set<TourDto> findByCitiesAndTransportType(String city, String transport);
}
