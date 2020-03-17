package com.anna.service.implementation;

import com.anna.exception.OperationFailedException;
import com.anna.mapping.TourMapper;
import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import com.anna.repository.*;
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
    private CityRepository cityRepository;
    private TransportRepository transportRepository;
    private HotelRepository hotelRepository;
    private UserRepository userRepository;
    private UserTourRepository userTourRepository;

    @Override
    public Set<TourDto> findAllTours() {
        Set<TourDto> allTours = new HashSet<>();
        List<Tour> tours = tourRepository.findAll();
        tours.forEach(tour -> {
            allTours.add(TourMapper.INSTANCE.tourEntityToTourDto(tour));
        });
        return allTours;
    }

    @Override
    public TourDetailDto findTourById(Long id) {
        return TourMapper.INSTANCE.tourEntityToTourDetailDto(tourRepository.findById(id)
                .orElseThrow(() -> new OperationFailedException(String.format("Tour with id %d doesn't exist", id))));
    }

    @Override
    public void saveTour(NewTourDto newTour) {
        Tour tour = TourMapper.INSTANCE.newTourDtoToTourEntity(newTour);
        tour.setDepartureCity(cityRepository.findByName(newTour.getDepartureCity())
                .orElseThrow(() -> new OperationFailedException(String.format("City %s doesn't exist", newTour.getDepartureCity()))));
        tour.setTransportType(transportRepository.findByTransportType(newTour.getTransportType())
                .orElseThrow(() -> new OperationFailedException(String.format("Transport type %s doesn't exist", newTour.getTransportType()))));
        tour.setCities(cityRepository.findByName(newTour.getCity())
                .orElseThrow(() -> new OperationFailedException(String.format("City %s doesn't exist", newTour.getCity()))));
        tour.setHotel(hotelRepository.findByHotelName(newTour.getHotel())
                .orElseThrow(() -> new OperationFailedException(String.format("Hotel %s doesn't exist", newTour.getHotel()))));
        tourRepository.save(tour);
    }

    @Override
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public void addTourToUserList(String email, Long id) throws OperationFailedException {
        Long userId = userRepository.findByEmail(email).get().getUserId();
        Long tourId = tourRepository.findById(id).get().getTourId();
        userTourRepository.saveWithoutId(userId, tourId);
    }
}
