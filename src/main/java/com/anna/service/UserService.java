package com.anna.service;

import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;

import java.util.Set;

public interface UserService {

    Set<UserDetailDto> findAllUsers();

    UserDetailDto findUserById(Long id);

    void addNewUser(RegistrationDto newUser);
}
