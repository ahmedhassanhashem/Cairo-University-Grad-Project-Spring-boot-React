package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.jwt.JwtUtils;
import com.interna.gatewayservice.base.jwt.TokenType;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.auth.LoginRequest;
import com.interna.gatewayservice.dto.auth.LoginResponse;
import com.interna.gatewayservice.model.user.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    private final Logger logger = Logger.getLogger(AuthenticationService.class.getName());

    public LoginResponse login(LoginRequest loginRequest) {
        new ObjectsValidator<LoginRequest>().apply(loginRequest);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        User user = userService.loadUserByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = LoginResponse.builder()
                .token(jwtUtils.generateToken(user, TokenType.ACCESS))
                .refresh((jwtUtils.generateToken(user, TokenType.REFRESH)))
                .build();

        tokenService.invokeAccessTokens(user.getId());
        tokenService.invokeRefreshTokens(user.getId());
        tokenService.addAccessAndRefreshToken(user, loginResponse);

        return loginResponse;
    }

    public LoginResponse extendToken(HttpServletRequest request) {
        final String authenticationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authenticationHeader == null) {
            throw new InsufficientAuthenticationException("Unauthorized Request, The token is missing!");
        }
        final String token = authenticationHeader.substring(7);
        String email = jwtUtils.getEmailFromToken(token);
        User user = userService.loadUserByEmail(email);

        LoginResponse loginResponse = LoginResponse.builder()
                .token(jwtUtils.generateToken(user, TokenType.ACCESS))
                .refresh(token)
                .build();

        tokenService.invokeAccessTokens(user.getId());
        tokenService.addAccessToken(user, loginResponse);

        return loginResponse;
    }

    public String logout(HttpServletRequest request) {
        final String authenticationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authenticationHeader == null) {
            throw new InsufficientAuthenticationException("Unauthorized Request, The token is missing!");
        }
        final String token = authenticationHeader.substring(7);

        String email = jwtUtils.getEmailFromToken(token);
        User user = userService.loadUserByEmail(email);

        tokenService.invokeAccessTokens(user.getId());
        tokenService.invokeRefreshTokens(user.getId());

        return "User logged out successfully";
    }

}
