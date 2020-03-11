package com.anna.mapping;

import com.anna.model.dto.RegistrationDto;
import com.anna.model.dto.UserDetailDto;
import com.anna.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "surname", source = "entity.surname"),
            @Mapping(target = "passportId", source = "entity.passportId")
    })
    UserDetailDto userEntityToUserDetailDto(User entity);

    @Mappings({
            @Mapping(target = "name", source = "registrationDto.name"),
            @Mapping(target = "surname", source = "registrationDto.surname"),
            @Mapping(target = "passportId", source = "registrationDto.passportId"),
            @Mapping(target = "email", source = "registrationDto.email"),
            @Mapping(target = "password", source = "registrationDto.password")
    })
    User registrationDtoToUserEntity(RegistrationDto registrationDto);
}
