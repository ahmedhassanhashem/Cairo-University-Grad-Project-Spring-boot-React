package com.interna.gatewayservice.repository.token;

import com.interna.gatewayservice.model.token.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessTokenRepository extends JpaRepository<AccessToken, String> {

    AccessToken findByToken(String token);

    List<AccessToken> findByUserIdAndInvokedFalse(String UserId);

}
