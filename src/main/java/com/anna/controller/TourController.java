package com.anna.controller;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
@RequestMapping(BASE_URL)
public class TourController {

    private final TourService tourService;

    @GetMapping(path = "/tours")
    public ResponseEntity<Set<TourDto>> findAllTours() {

        return ResponseEntity.ok().body(tourService.findAllTours());
    }

    @GetMapping(path = "/tours", params = "transport")
    public ResponseEntity<Set<TourDto>> findAllToursByTransport(@RequestParam String transport) {

        return ResponseEntity.ok().body(tourService.findToursByTransport(transport));
    }

    @GetMapping(path = "/tours", params = "city")
    public ResponseEntity<Set<TourDto>> findAllToursByCities(@RequestParam String city) {

        return ResponseEntity.ok().body(tourService.findToursByCity(city));
    }

    @GetMapping(path = "/tours", params = {"city", "transport"})
    public ResponseEntity<Set<TourDto>> findAllToursByCitiesAndTransportType(@RequestParam String city,
                                                                             @RequestParam String transport) {

        return ResponseEntity.ok().body(tourService.findByCityAndTransportType(city, transport));
    }

    @GetMapping(path = "/tours", params = {"sort=price:desc", "sort=price:asc"})
    public ResponseEntity<Set<TourDto>> sortTours() {

        return ResponseEntity.ok().body(tourService.sortTours());
    }

    @GetMapping(path = "/tours/{id}")
    public ResponseEntity<TourDetailDto> findTourById(@PathVariable Long id) {
        log.info("get details of tour");
        return ResponseEntity.ok().body(tourService.findTourById(id));
    }

    @GetMapping(path = "/tours/favorites")
    public ResponseEntity<Set<TourDto>> findFavoriteTours(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok().body(tourService.findFavoriteTours(email));
    }

    @PutMapping(path = "/tours/favorites/{id}")
    public ResponseEntity deleteTourFromUserList(Authentication authentication, @PathVariable Long id) {
        log.info("delete tour from personal list");
        String userEmail = authentication.getName();
        tourService.deleteTourFromUserList(userEmail, id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "/tours")
    public ResponseEntity<String> addNewTour(@Valid @RequestBody NewTourDto newTour) {
        log.info("save new tour");
        tourService.addNewTour(newTour);
        return ResponseEntity.ok().body("new tour " + newTour.getTourName() + " has been created");
    }

    @PutMapping(path = "/tours/{id}")
    public ResponseEntity<String> addTourToUserList(Authentication authentication, @PathVariable Long id) {
        log.info("save tour to personal list");
        String userEmail = authentication.getName();
        tourService.addTourToUserList(userEmail, id);
        return ResponseEntity.ok().body("tour has been  added to personal list");
    }

    @DeleteMapping(path = "/tours/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable Long id) {
        log.info("delete tour");
        tourService.deleteTour(id);
        return ResponseEntity.noContent().build();
    }
}
