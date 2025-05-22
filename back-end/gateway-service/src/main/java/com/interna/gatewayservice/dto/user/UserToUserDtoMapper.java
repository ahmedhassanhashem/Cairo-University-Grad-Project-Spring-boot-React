package com.interna.gatewayservice.dto.user;

import com.interna.gatewayservice.dto.role.RoleToRoleDtoMapper;
import com.interna.gatewayservice.model.user.User;

import java.util.function.Function;

public class UserToUserDtoMapper implements Function<User, UserDto> {

    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                new RoleToRoleDtoMapper().apply(user.getRole()),
                user.isEnabled(),
                user.isLocked(),
                user.isExpired(),
                user.getCreatedDate()
        );

    }
}
