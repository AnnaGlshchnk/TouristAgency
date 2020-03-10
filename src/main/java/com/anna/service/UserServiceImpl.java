package com.anna.service;

import com.anna.mapping.UserMapper;
import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;
import com.anna.model.entity.User;
import com.anna.repository.RoleRepository;
import com.anna.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public Set<UserDetailDto> findAllUsers() {
        Set<UserDetailDto> allUsers = new HashSet<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            allUsers.add(UserMapper.INSTANCE.registrationDtoToUserEntity(user));
        });
        return allUsers;
    }

    @Override
    public UserDetailDto findUserById(Long id) {
        return UserMapper.INSTANCE.registrationDtoToUserEntity(userRepository.findById(id).get());
    }

    @Override
    public void addNewUser(RegistrationDto newUser) {

        User user = UserMapper.INSTANCE.registrationDtoToUserEntity(newUser);
        user.setRoles(Collections.singletonList(roleRepository.findByRoleName("user")));
        userRepository.save(user);
    }
}
