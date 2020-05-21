package com.anna.service.implementation;

import com.anna.exception.OperationFailedException;
import com.anna.mapping.UserMapper;
import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;
import com.anna.model.entity.User;
import com.anna.repository.RoleRepository;
import com.anna.repository.UserRepository;
import com.anna.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public static final String USER_ROLE = "user";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public Set<UserDetailDto> findAllUsers() throws OperationFailedException {
        List<User> users = userRepository.findAll();
        return userMapper.userEntityListToUserDetailDtoSet(users);
    }

    @Override
    public UserDetailDto findUserById(Long id) throws OperationFailedException {
        return userMapper.userEntityToUserDetailDto(userRepository.findById(id)
                .orElseThrow(
                        () -> new OperationFailedException(String.format("User with id %d doesn't exist", id))));
    }

    @Override
    public void addNewUser(RegistrationDto newUser) throws OperationFailedException {

        User user = userMapper.registrationDtoToUserEntity(newUser);
        user.setRoles(Collections.singletonList(roleRepository.findByRoleName(USER_ROLE)));
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserDetailDto updateUser) throws OperationFailedException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new OperationFailedException(String.format("User with id %d doesn't exist", id)));
        userMapper.mapUserEntityToUserDetailDto(updateUser, user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws OperationFailedException {
        userRepository.deleteById(id);
    }
}
