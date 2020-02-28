package com.anna.service;

import com.anna.model.dto.UserDetail;

import java.util.Set;

public interface UserService {

    Set<UserDetail> findAllUsers();

    UserDetail findUserById(Long id);
}
