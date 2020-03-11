package com.anna.controller;

import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;
import com.anna.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(path = "/register")
    public ResponseEntity<String> addNewUser(@Valid @RequestBody RegistrationDto newUser) {
        userService.addNewUser(newUser);
        return ResponseEntity.ok().body("new user has created");
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UserDetailDto updateUser) {
        userService.updateUser(id, updateUser);
        return ResponseEntity.accepted().body("user has updated");
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().body("user has deleted");
    }

}
