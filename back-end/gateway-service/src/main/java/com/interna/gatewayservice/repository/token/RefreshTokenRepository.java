package com.interna.gatewayservice.repository.token;

import com.interna.gatewayservice.model.token.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    RefreshToken findByToken(String token);

    List<RefreshToken> findByUserIdAndInvokedFalse(String UserId);

}
