package com.anna.service;

import com.anna.exception.OperationFailedException;
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

    public static final String USER_ROLE = "user";
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public Set<UserDetailDto> findAllUsers() throws OperationFailedException {
        Set<UserDetailDto> allUsers = new HashSet<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            allUsers.add(UserMapper.INSTANCE.userEntityToUserDetailDto(user));
        });
        return allUsers;
    }

    @Override
    public UserDetailDto findUserById(Long id) throws OperationFailedException {
        return UserMapper.INSTANCE.userEntityToUserDetailDto(userRepository.findById(id)
                .orElseThrow(
                        () -> new OperationFailedException(String.format("User with id %d doesn't exist", id))));
    }

    @Override
    public void addNewUser(RegistrationDto newUser) throws OperationFailedException {

        User user = UserMapper.INSTANCE.registrationDtoToUserEntity(newUser);
        user.setRoles(Collections.singletonList(roleRepository.findByRoleName(USER_ROLE)));
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserDetailDto updateUser) throws OperationFailedException {
        User user = userRepository.findById(id).get();
        user.setName(updateUser.getName());
        user.setSurname(updateUser.getSurname());
        user.setPassportId(updateUser.getPassportId());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws OperationFailedException {
        userRepository.deleteById(id);
    }
}
