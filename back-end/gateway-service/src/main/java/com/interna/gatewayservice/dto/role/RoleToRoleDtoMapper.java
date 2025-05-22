package com.interna.gatewayservice.dto.role;

import com.interna.gatewayservice.model.Role;

import java.util.function.Function;

public class RoleToRoleDtoMapper implements Function<Role, RoleDto> {

    @Override
    public RoleDto apply(Role role) {
        return new RoleDto(
                role.getId(),
                role.getName().toUpperCase()
        );
    }
}
