package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.auth.LoginRequest;
import com.interna.gatewayservice.dto.auth.LoginResponse;
import com.interna.gatewayservice.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                ApiResponse.<LoginResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(authenticationService.login(request))
                        .build()
        );
    }


    @GetMapping("refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        return ResponseEntity.ok(
                ApiResponse.<LoginResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(authenticationService.extendToken(request))
                        .build()
        );
    }

    @GetMapping("logout")
    public ResponseEntity<ApiResponse<String>> logout(HttpServletRequest request) {
        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(authenticationService.logout(request))
                        .build()
        );
    }

}
