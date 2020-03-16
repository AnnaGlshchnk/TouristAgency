package com.anna.service;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;

import java.util.Set;

public interface TourService {

    Set<TourDto> findAllTours();


    TourDetailDto findTourById(Long id);

    void saveTour(NewTourDto newTour);

    void deleteTour(Long id);
}
