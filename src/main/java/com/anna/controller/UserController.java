package com.anna.controller;

import com.anna.model.dto.UserDetailDto;
import com.anna.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@AllArgsConstructor
@RequestMapping(BASE_URL)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<Set<UserDetailDto>> findAllUsers() {
        logger.info("get list of users");
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDetailDto> findUserById(@PathVariable Long id) {
        logger.info("get user by id");
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

}
