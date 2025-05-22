package com.interna.gatewayservice.base.config.password;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordFactory {

    public final PasswordEncoder passwordEncoder;

    public String encode(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    public boolean isMatched(String plain, String cipher) {
        return passwordEncoder.matches(plain, cipher);
    }
}
