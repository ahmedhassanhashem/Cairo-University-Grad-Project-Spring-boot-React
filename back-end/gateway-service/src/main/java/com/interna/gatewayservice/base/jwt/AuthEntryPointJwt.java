package com.interna.gatewayservice.base.jwt;

import com.interna.gatewayservice.base.security.AuthenticationProviderConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        Arrays.stream(authException.getStackTrace()).forEach(error -> {
            if (error.getClassName().equals(AuthenticationProviderConfig.class.getName())) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                try {
                    response.getWriter().write(authException.getLocalizedMessage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
