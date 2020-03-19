package com.anna.controller;

import com.anna.model.dto.NewTourDto;
import com.anna.model.dto.TourDetailDto;
import com.anna.model.dto.TourDto;
import com.anna.service.TourService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class TourController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private TourService tourService;

    @GetMapping(path = "/tours")
    public ResponseEntity<Set<TourDto>> findAllTours(@RequestParam(required = false) String city,
                                                     @RequestParam(required = false) String transport) {
        logger.info("get all touts");
        Set<TourDto> allTours = null;
        if (city != null && transport != null) {
            allTours = tourService.findByCitiesAndTransportType(city, transport);
        } else if (city != null) {
            allTours = tourService.findToursByCities(city);
        } else if (transport != null) {
            allTours = tourService.findToursByTransport(transport);
        } else {
            allTours = tourService.findAllTours();
        }

        return ResponseEntity.ok().body(allTours);
    }

    @GetMapping(path = "/tours/sorting")
    public ResponseEntity<Set<TourDto>> sortTours() {
        logger.info("get all touts");
        return ResponseEntity.ok().body(tourService.sortTours());
    }

    @GetMapping(path = "/tours/{id}")
    public ResponseEntity<TourDetailDto> findTourById(@PathVariable Long id) {
        logger.info("get details of tour");
        return ResponseEntity.ok().body(tourService.findTourById(id));
    }

    @GetMapping(path = "/tours/favorites")
    public ResponseEntity<Set<TourDto>> findFavoriteTours(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok().body(tourService.findFavoriteTours(email));
    }

    @PutMapping(path = "/tours/favorites/{id}")
    public ResponseEntity<String> deleteTourFromUserList(Authentication authentication, @PathVariable Long id) {
        logger.info("delete tour from personal list");
        String userEmail = authentication.getName();
        tourService.deleteTourFromUserList(userEmail, id);
        return ResponseEntity.ok().body("tour has deleted from personal list");
    }

    @PostMapping(path = "/tours")
    public ResponseEntity<String> addNewTour(@Valid @RequestBody NewTourDto newTour) {
        logger.info("save new tour");
        tourService.addNewTour(newTour);
        return ResponseEntity.ok().body("new tour " + newTour.getName() + " has created");
    }

    @PutMapping(path = "/tours/{id}")
    public ResponseEntity<String> addTourToUserList(Authentication authentication, @PathVariable Long id) {
        logger.info("save tour to personal list");
        String userEmail = authentication.getName();
        tourService.addTourToUserList(userEmail, id);
        return ResponseEntity.ok().body("tour has added to personal list");
    }

    @DeleteMapping(path = "/tours/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable Long id) {
        logger.info("delete tour");
        tourService.deleteTour(id);
        return ResponseEntity.ok().body("tour has deleted");
    }
}
