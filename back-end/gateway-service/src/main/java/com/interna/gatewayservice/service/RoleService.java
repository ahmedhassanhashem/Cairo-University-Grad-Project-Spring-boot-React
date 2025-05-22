package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.dto.role.RoleDto;
import com.interna.gatewayservice.dto.role.RoleToRoleDtoMapper;
import com.interna.gatewayservice.model.Role;
import com.interna.gatewayservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<RoleDto> roleList() {
        return roleRepository.findAll()
                .stream()
                .filter(role -> role.getStatus().equalsIgnoreCase("o"))
                .map(role -> new RoleToRoleDtoMapper().apply(role))
                .collect(Collectors.toList());
    }

    public RoleDto findRole(int id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException(String.format("Role id '%s' is not found!", id))
        );
        return new RoleToRoleDtoMapper().apply(role);
    }


}
