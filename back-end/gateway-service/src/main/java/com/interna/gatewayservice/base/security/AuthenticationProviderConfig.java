package com.interna.gatewayservice.base.security;


import com.interna.gatewayservice.base.config.password.PasswordFactory;
import com.interna.gatewayservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationProviderConfig implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordFactory passwordFactory;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        final UserDetails user = userService.loadUserByUsername(username);
        if (!passwordFactory.isMatched(password, user.getPassword())) {
            throw new BadCredentialsException("Username or Password is incorrect.");
        }
        if (!user.isEnabled()) {
            throw new BadCredentialsException("User is disabled.");
        }
        if (!user.isAccountNonLocked()) {
            throw new BadCredentialsException("User is locked.");
        }
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
