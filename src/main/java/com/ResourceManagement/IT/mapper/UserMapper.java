package com.ResourceManagement.IT.mapper;

import com.ResourceManagement.IT.dto.UserDto;
import com.ResourceManagement.IT.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUserEntity(UserDto userDto);

    UserDto toUserDto(User user);

}
