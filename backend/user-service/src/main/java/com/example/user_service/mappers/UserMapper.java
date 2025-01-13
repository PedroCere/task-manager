package com.example.user_service.mappers;

import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.model.User;
import com.example.user_service.dto.UserDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User user);

    List<UserDto> toListOfDto(List<User> users);

    List<User> toListOfEntity(List<UserResponseDto> dtos);

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",expression = "java(java.time.LocalDateTime.now())")
    void updateUserFromDto(UserDto userDto, @MappingTarget User user);
}
