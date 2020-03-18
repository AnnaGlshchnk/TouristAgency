package com.anna.service.implementation;

import com.anna.exception.OperationFailedException;
import com.anna.mapping.TourMapper;
import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import com.anna.model.entity.User;
import com.anna.repository.*;
import com.anna.service.TourService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
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
    public void addNewTour(NewTourDto newTour) {
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
        User user = userRepository.findByEmail(email).get();
        Tour tour = tourRepository.findById(id).get();
        tour.getUsers().add(user);
        tourRepository.save(tour);
    }

    @Override
    public Set<TourDto> findFavoriteTours(String email) {
        Set<TourDto> allFavoritesTours = new HashSet<>();
        Set<Tour> tours = tourRepository.findToursByUsers(userRepository.findByEmail(email).get());
        tours.forEach(tour -> {
            allFavoritesTours.add(TourMapper.INSTANCE.tourEntityToTourDto(tour));
        });
        return allFavoritesTours;
    }

    @Override
    public Set<TourDto> findToursByCities(String city) {
        Set<TourDto> filterTours = new HashSet<>();
        Set<Tour> tours = tourRepository.findToursByCities(cityRepository.findByName(city).get());
        tours.forEach(tour -> {
            filterTours.add(TourMapper.INSTANCE.tourEntityToTourDto(tour));
        });
        return filterTours;
    }

    @Override
    public Set<TourDto> sortTours() {
        Set<TourDto> sortedTours = new HashSet<>();
        List<Tour> tours = tourRepository.findAll(Sort.by("price"));
        tours.forEach(tour -> {
            sortedTours.add(TourMapper.INSTANCE.tourEntityToTourDto(tour));
        });
        return sortedTours;
    }
}
