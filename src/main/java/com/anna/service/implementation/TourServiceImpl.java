package com.anna.service.implementation;

import com.anna.exception.OperationFailedException;
import com.anna.mapping.TourMapper;
import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.model.entity.Tour;
import com.anna.model.entity.User;
import com.anna.repository.CityRepository;
import com.anna.repository.HotelRepository;
import com.anna.repository.TourRepository;
import com.anna.repository.TransportRepository;
import com.anna.repository.UserRepository;
import com.anna.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;
    private final CityRepository cityRepository;
    private final TransportRepository transportRepository;
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;

    @Override
    public Set<TourDto> findAllTours() {
        List<Tour> tours = tourRepository.findAll();
        return TourMapper.INSTANCE.tourEntityListToTourDtoSet(tours);
    }

    @Override
    public TourDetailDto findTourById(Long id) {
        return TourMapper.INSTANCE.tourEntityToTourDetailDto(tourRepository.findById(id)
                .orElseThrow(() -> new OperationFailedException(String.format("Tour with id %d doesn't exist", id))));
    }

    @Override
    public void addNewTour(NewTourDto newTour) {
        Tour tour = TourMapper.INSTANCE.newTourDtoToTourEntity(newTour);
        tour.setDepartureCity(cityRepository.findByName(newTour.getDepartureCity().getCity())
                .orElseThrow(() -> new OperationFailedException(String.format("City %s doesn't exist", newTour.getDepartureCity()))));
        tour.setTransportType(transportRepository.findByTransportType(newTour.getTransportType().getTransportType())
                .orElseThrow(() -> new OperationFailedException(String.format("Transport type %s doesn't exist", newTour.getTransportType()))));
        tour.setCities(cityRepository.findByName(newTour.getCity().getCity())
                .orElseThrow(() -> new OperationFailedException(String.format("City %s doesn't exist", newTour.getCity()))));
        tour.setHotel(hotelRepository.findByHotelName(newTour.getHotel().getHotelName())
                .orElseThrow(() -> new OperationFailedException(String.format("Hotel %s doesn't exist", newTour.getHotel()))));
        tourRepository.save(tour);
    }

    @Override
    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public void addTourToUserList(String email, Long id) throws OperationFailedException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new OperationFailedException(String.format("User with email  %s doesn't exist", email)));
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new OperationFailedException(String.format("Tour with id  %d doesn't exist", id)));
        if (tour.getUsers() != null) {
            tour.getUsers().add(user);
            tourRepository.save(tour);
        } else throw new OperationFailedException("Tour doesn't have user list");
    }

    @Override
    public void deleteTourFromUserList(String email, Long id) {
        User userFromBD = userRepository.findByEmail(email)
                .orElseThrow(() -> new OperationFailedException(String.format("User with email  %s doesn't exist", email)));
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new OperationFailedException(String.format("Tour with id  %d doesn't exist", id)));
        if (tour.getUsers() != null) {
            tour.getUsers().forEach(user -> {
                if (user.getEmail().equals(email)) {
                    tour.getUsers().remove(userFromBD);
                }
            });
            tourRepository.save(tour);
        } else throw new OperationFailedException("Tour doesn't have user list");
    }

    @Override
    public Set<TourDto> findFavoriteTours(String email) {
        List<Tour> tours = tourRepository.findToursByUsers(userRepository.findByEmail(email)
                .orElseThrow(() -> new OperationFailedException(String.format("User with email  %s doesn't exist", email))));
        return TourMapper.INSTANCE.tourEntityListToTourDtoSet(tours);
    }

    @Override
    public Set<TourDto> findToursByCities(String city) {
        List<Tour> tours = tourRepository.findToursByCities(cityRepository.findByName(city)
                .orElseThrow(() -> new OperationFailedException(String.format("City %s doesn't exist", city))));
        return TourMapper.INSTANCE.tourEntityListToTourDtoSet(tours);
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

    @Override
    public Set<TourDto> findToursByTransport(String transport) {
        List<Tour> tours = tourRepository.findToursByTransportType(transportRepository.findByTransportType(transport)
                .orElseThrow(() -> new OperationFailedException(String.format("Transport type %s doesn't exist", transport))));
        return TourMapper.INSTANCE.tourEntityListToTourDtoSet(tours);
    }

    @Override
    public Set<TourDto> findByCitiesAndTransportType(String city, String transport) {
        List<Tour> tours = tourRepository.findByCitiesAndTransportType(
                cityRepository.findByName(city)
                        .orElseThrow(() -> new OperationFailedException(String.format("City %s doesn't exist", city))),
                transportRepository.findByTransportType(transport)
                        .orElseThrow(() -> new OperationFailedException(String.format("Transport type %s doesn't exist", transport))));
        return TourMapper.INSTANCE.tourEntityListToTourDtoSet(tours);
    }
}
