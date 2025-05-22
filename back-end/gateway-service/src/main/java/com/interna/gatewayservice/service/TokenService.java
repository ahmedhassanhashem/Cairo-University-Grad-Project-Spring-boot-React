package com.interna.gatewayservice.service;


import com.interna.gatewayservice.dto.auth.LoginResponse;
import com.interna.gatewayservice.model.token.AccessToken;
import com.interna.gatewayservice.model.token.RefreshToken;
import com.interna.gatewayservice.model.user.User;
import com.interna.gatewayservice.repository.token.AccessTokenRepository;
import com.interna.gatewayservice.repository.token.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TokenService {

    private final AccessTokenRepository accessTokenRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public void addAccessAndRefreshToken(User user, LoginResponse loginResponse) {
        accessTokenRepository.save(
                new AccessToken(
                        null,
                        loginResponse.getToken(),
                        user,
                        false,
                        false,
                        LocalDateTime.now()
                )
        );

        refreshTokenRepository.save(
                new RefreshToken(
                        null,
                        loginResponse.getRefresh(),
                        user,
                        false,
                        false,
                        LocalDateTime.now()
                )
        );
    }

    public void addAccessToken(User user, LoginResponse loginResponse) {
        accessTokenRepository.save(
                new AccessToken(
                        null,
                        loginResponse.getToken(),
                        user,
                        false,
                        false,
                        LocalDateTime.now()
                )
        );
    }

    public void expireToken(String token) {
        AccessToken accessToken = accessTokenRepository.findByToken(token);
        if (accessToken != null) {
            accessToken.setExpired(true);
            accessTokenRepository.save(accessToken);
        }

        RefreshToken refreshToken = refreshTokenRepository.findByToken(token);
        if (refreshToken != null) {
            refreshToken.setExpired(true);
            refreshTokenRepository.save(refreshToken);
        }
    }

    public void invokeAccessTokens(String userId) {
        List<AccessToken> accessTokenList = accessTokenRepository.findByUserIdAndInvokedFalse(userId).stream()
                .peek(toke -> toke.setInvoked(true)).toList();
        accessTokenRepository.saveAll(accessTokenList);
    }

    public void invokeRefreshTokens(String userId) {
        List<RefreshToken> refreshTokenList = refreshTokenRepository.findByUserIdAndInvokedFalse(userId).stream()
                .peek(toke -> toke.setInvoked(true)).toList();
        refreshTokenRepository.saveAll(refreshTokenList);
    }

    public boolean isAccessTokeValid(String token) {
        AccessToken accessToken = accessTokenRepository.findByToken(token);
        return !accessToken.isExpired() && !accessToken.isInvoked();
    }

    public boolean isRefreshTokeValid(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token);
        return !refreshToken.isExpired() && !refreshToken.isInvoked();
    }

}
