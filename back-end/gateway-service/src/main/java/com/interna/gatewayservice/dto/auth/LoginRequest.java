package com.interna.gatewayservice.dto.auth;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginRequest {

    @NotBlank(message = "email is empty!")
    private String email;

    @NotBlank(message = "password is empty!")
    private String password;
}
