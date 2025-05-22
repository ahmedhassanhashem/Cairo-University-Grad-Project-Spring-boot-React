package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.user.PasswordUpdatingDto;
import com.interna.gatewayservice.dto.user.UserDto;
import com.interna.gatewayservice.dto.user.UserRegisterDto;
import com.interna.gatewayservice.dto.user.UserUpdatingDto;
import com.interna.gatewayservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/user")
public class UserController {

    private final UserService userService;


    @PostMapping("register")
    public ResponseEntity<ApiResponse<String>> addUser(@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(userService.addUser(userRegisterDto))
                                .build()
                );
    }


    @PutMapping("password/change")
    public ResponseEntity<ApiResponse<String>> changePassword(@RequestBody PasswordUpdatingDto passwordDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(ApiResponse.<String>builder()
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .status(HttpStatus.ACCEPTED.name())
                        .timestamp(LocalDateTime.now())
                        .data(userService.changePassword(passwordDto))
                        .build());
    }


    @GetMapping("id/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<UserDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(userService.getUserDtoById(id))
                        .build()
        );
    }

    @GetMapping("email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(
                ApiResponse.<UserDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(userService.getUserDtoByEmail(email))
                        .build()
        );
    }

}
