package com.anna.controller;

import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;
import com.anna.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

import static com.anna.util.Constant.BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<Set<UserDetailDto>> findAllUsers() {
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDetailDto> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @PostMapping(path = "/user")
    public ResponseEntity<String> addNewUser(@Valid @RequestBody RegistrationDto newUser) {
        userService.addNewUser(newUser);
        return ResponseEntity.ok().body("new user has been created");
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @Valid @RequestBody UserDetailDto updateUser) {
        userService.updateUser(id, updateUser);
        return ResponseEntity.accepted().body("user has been updated");
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
