package com.anna.service.implementation;

import com.anna.mapping.TourMapper;
import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import com.anna.repository.TourRepository;
import com.anna.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;

    @Override
    public Set<TourDto> findAllTours() {
        Set<TourDto> allTours = new HashSet<>();
        List<Tour> tours = tourRepository.findAll();
        tours.forEach(tour -> {
            allTours.add(TourMapper.INSTANCE.tourEntityToTourDto(tour));
        });
        return allTours;
    }
}
