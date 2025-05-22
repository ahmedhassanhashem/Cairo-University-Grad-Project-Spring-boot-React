package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.role.RoleDto;
import com.interna.gatewayservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/role")
public class RoleController {

    private final RoleService roleService;


    @GetMapping("list")
    public ResponseEntity<ApiResponse<List<RoleDto>>> roleList() {
        return ResponseEntity.ok(
                ApiResponse.<List<RoleDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(roleService.roleList())
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<RoleDto>> getRole(@RequestParam(name = "id") int id) {
        return ResponseEntity.ok(
                ApiResponse.<RoleDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(roleService.findRole(id))
                        .build()
        );

    }

}
