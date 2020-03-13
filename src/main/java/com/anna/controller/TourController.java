package com.anna.controller;

import com.anna.model.dto.TourDto;
import com.anna.service.TourService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class TourController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private TourService tourService;

    @GetMapping(path = "/tours")
    public ResponseEntity<Set<TourDto>> findAllTours() {
        logger.info("get all touts");
        return ResponseEntity.ok().body(tourService.findAllTours());
    }
}
