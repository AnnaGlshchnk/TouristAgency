package com.anna.mapping;

import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;
import com.anna.model.entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @IterableMapping(elementTargetType = UserDetailDto.class)
    Set<UserDetailDto> userEntityListToUserDetailDtoSet(List<User> users);

    UserDetailDto userEntityToUserDetailDto(User entity);

    User registrationDtoToUserEntity(RegistrationDto registrationDto);

    void mapUserEntityToUserDetailDto(UserDetailDto userDetailDto, @MappingTarget User user);
}
