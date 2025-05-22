package com.interna.gatewayservice.base.jwt;


import com.interna.gatewayservice.model.user.User;
import com.interna.gatewayservice.service.AppConfigService;
import com.interna.gatewayservice.service.TokenService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final AppConfigService appConfigService;
    private final TokenService tokenService;

    private final Logger logger = Logger.getLogger(JwtUtils.class.getName());


    public String generateToken(final User user, TokenType tokenType) {
        return Jwts.builder()
                .setId(user.getId())
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(getExpirationDate(tokenType))
                .claim("role", user.getRole().getName())
                .claim("name", user.getName())
                .claim("tokenType", tokenType.name())
                .signWith(SignatureAlgorithm.HS512, getTokenSecret())
                .compact();
    }

    public boolean isTokenValid(final String token, final UserDetails user) {
        final String userEmail = getEmailFromToken(token);
        final Date tokenExpirationDate = getClaims(token).getExpiration();
        return userEmail.equalsIgnoreCase(user.getUsername()) && tokenExpirationDate.after(new Date());
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public String getTokenType(String token) {
        return (String) getClaims(token).get("tokenType");
    }

    private Date getExpirationDate(TokenType tokenType) {
        switch (tokenType) {
            case ACCESS -> {
                return new Date(System.currentTimeMillis() + (getTokenAccessExpiration() * 1000L));
            }
            case REFRESH -> {
                return new Date(System.currentTimeMillis() + (getRefreshAccessExpiration() * 1000L));
            }
            default -> {
                return new Date();
            }
        }
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(getTokenSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            logger.warning(String.format("Invalid JWT signature: {%s}", e.getMessage()));
            throw new InsufficientAuthenticationException("We are sorry. there is an issue, Kindly contact system administrator.");
        } catch (MalformedJwtException e) {
            logger.warning(String.format("Invalid JWT token: {%s}", e.getMessage()));
            throw new InsufficientAuthenticationException("We are sorry. there is an issue, Kindly contact system administrator.");
        } catch (ExpiredJwtException e) {
            tokenService.expireToken(token);
            throw new InsufficientAuthenticationException("Unauthorized Request, The token is expired!");
        } catch (UnsupportedJwtException e) {
            logger.warning(String.format("JWT token is unsupported: {%s}", e.getMessage()));
            throw new InsufficientAuthenticationException("We are sorry. there is an issue, Kindly contact system administrator.");
        } catch (IllegalArgumentException e) {
            logger.warning(String.format("JWT claims string is empty: {%s}", e.getMessage()));
            throw new InsufficientAuthenticationException("We are sorry. there is an issue, Kindly contact system administrator.");
        }
    }

    private String getTokenSecret() {
        String TOKEN_SECRET_KEY = "TOKEN_SECRET";
        return appConfigService.getConfigurationValue(TOKEN_SECRET_KEY);
    }

    private int getTokenAccessExpiration() {
        String TOKEN_ACCESS_EXPIRATION_KEY = "TOKEN_ACCESS_EXPIRATION";
        return Integer.parseInt(appConfigService.getConfigurationValue(TOKEN_ACCESS_EXPIRATION_KEY));
    }

    private int getRefreshAccessExpiration() {
        String REFRESH_ACCESS_EXPIRATION_KEY = "REFRESH_ACCESS_EXPIRATION";
        return Integer.parseInt(appConfigService.getConfigurationValue(REFRESH_ACCESS_EXPIRATION_KEY));
    }


}
