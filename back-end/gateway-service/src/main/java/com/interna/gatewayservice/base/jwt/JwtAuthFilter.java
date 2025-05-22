package com.interna.gatewayservice.base.jwt;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.interna.gatewayservice.base.exception.ApiError;
import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.service.TokenService;
import com.interna.gatewayservice.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Configuration
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final TokenService tokenService;
    private final JwtUtils jwtUtils;

    private final Logger logger = Logger.getLogger(JwtAuthFilter.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authenticationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String endpoint = request.getRequestURI();

        if (authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")) {
            if (!endpoint.contains("login") && !endpoint.contains("register") && !endpoint.contains("/role/list")) {
                setResponse(request, response, HttpStatus.UNAUTHORIZED, "Unauthorized Request, The token is missing!");
                return;
            }
            if (endpoint.contains("refresh")) return;
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String jwtToken = authenticationHeader.substring(7);
            final String tokenType = jwtUtils.getTokenType(jwtToken);

            if (!endpoint.contains("refresh") && TokenType.REFRESH.name().equals(tokenType)) {
                setResponse(request, response, HttpStatus.UNAUTHORIZED, "Unauthorized Request, The token is invalid!");
                logger.warning("JWT Refresh Token cannot be used here.");
                return;
            }

            if (endpoint.contains("refresh") && TokenType.ACCESS.name().equals(tokenType)) {
                setResponse(request, response, HttpStatus.UNAUTHORIZED, "Unauthorized Request, The token is invalid!");
                logger.warning("JWT Access Token cannot be used here.");
                return;
            }

            final String userEmail = jwtUtils.getEmailFromToken(jwtToken);
            final UserDetails user = userService.loadUserByUsername(userEmail);

            if (jwtUtils.isTokenValid(jwtToken, user) && isTokenValid(TokenType.valueOf(tokenType.toUpperCase()), jwtToken)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userEmail,
                        null,
                        user.getAuthorities()
                );

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } else {
                throw new InsufficientAuthenticationException("Unauthorized Request, The token is invoked!");
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            setResponse(request, response, HttpStatus.UNAUTHORIZED, e.getLocalizedMessage());
        }
    }

    private void setResponse(HttpServletRequest request, HttpServletResponse response, HttpStatus status, String message) throws IOException {
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        String jsonString = objectMapper.writeValueAsString(
                new ApiError(
                        request.getRequestURI(),
                        message,
                        status.value(),
                        LocalDateTime.now()
                )
        );
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status.value());
        out.print(jsonString);
        out.flush();
    }

    private boolean isTokenValid(TokenType type, String token) {
        switch (type) {
            case ACCESS -> {
                return tokenService.isAccessTokeValid(token);
            }
            case REFRESH -> {
                return tokenService.isRefreshTokeValid(token);
            }
            default -> {
                return false;
            }
        }
    }

}
