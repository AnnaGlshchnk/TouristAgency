package com.anna.service;

import com.anna.exception.OperationFailedException;
import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;

import java.util.Set;

public interface UserService {

    Set<UserDetailDto> findAllUsers() throws OperationFailedException;

    UserDetailDto findUserById(Long id) throws OperationFailedException;

    void addNewUser(RegistrationDto newUser) throws OperationFailedException;

    void updateUser(Long id, UserDetailDto updateUser) throws OperationFailedException;

    void deleteUser(Long id) throws OperationFailedException;
}
