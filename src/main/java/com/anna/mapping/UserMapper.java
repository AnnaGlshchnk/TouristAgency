package com.anna.mapping;

import com.anna.model.dto.UserDetailDto;
import com.anna.model.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserMapper {

    public Set<UserDetailDto> mapUserEntityToUsersDetail(List<User> users) {

        Set<UserDetailDto> userDetailDtoSet = new HashSet<>();
        users.forEach(user -> {
            UserDetailDto userDetailDto = new UserDetailDto();
            userDetailDto.setName(user.getName());
            userDetailDto.setSurname(user.getSurname());
            userDetailDto.setPassportId(user.getPassportId());
            userDetailDtoSet.add(userDetailDto);
        });

        return userDetailDtoSet;
    }

    public UserDetailDto mapUserEntityToUserDetail(Optional<User> user) {

        UserDetailDto userDetailDto = null;
        if (user.isPresent()) {
            userDetailDto = new UserDetailDto();

            userDetailDto.setName(user.get().getName());
            userDetailDto.setSurname(user.get().getSurname());
            userDetailDto.setPassportId(user.get().getPassportId());
        }
        return userDetailDto;
    }
}
