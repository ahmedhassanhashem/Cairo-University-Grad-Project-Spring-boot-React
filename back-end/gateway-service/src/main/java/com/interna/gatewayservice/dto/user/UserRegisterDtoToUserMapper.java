package com.interna.gatewayservice.dto.user;

import com.interna.gatewayservice.base.config.password.PasswordFactory;
import com.interna.gatewayservice.model.user.User;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.function.Function;


@RequiredArgsConstructor
public class UserRegisterDtoToUserMapper implements Function<UserRegisterDto, User> {

    private final PasswordFactory passwordFactory;

    @Override
    public User apply(UserRegisterDto userRegisterDto) {
        return new User(
                null,
                userRegisterDto.getName(),
                userRegisterDto.getEmail(),
                passwordFactory.encode(userRegisterDto.getPassword()),
                userRegisterDto.getRole(),
                true,
                false,
                false,
                LocalDateTime.now()
        );
    }
}
