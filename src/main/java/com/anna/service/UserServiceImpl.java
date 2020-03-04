package com.anna.service;

import com.anna.dao.UserRepository;
import com.anna.mapping.UserMapper;
import com.anna.model.dto.UserDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    public Set<UserDetailDto> findAllUsers() {
        UserMapper userMapper = new UserMapper();
        return userMapper.mapUserEntityToUsersDetail(userRepository.findAll());
    }

    @Override
    public UserDetailDto findUserById(Long id) {
        UserMapper userMapper = new UserMapper();
        return userMapper.mapUserEntityToUserDetail(userRepository.findById(id));
    }
}
