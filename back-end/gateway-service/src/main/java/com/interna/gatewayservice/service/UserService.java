package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.config.password.PasswordFactory;
import com.interna.gatewayservice.base.exception.DuplicationDataException;
import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.user.*;
import com.interna.gatewayservice.model.user.User;
import com.interna.gatewayservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordFactory passwordFactory;

    public String addUser(UserRegisterDto userRegisterDto) {
        new ObjectsValidator<UserRegisterDto>().apply(userRegisterDto);
        if (userRepository.findUserByEmail(userRegisterDto.getEmail()).isPresent()) {
            throw new DuplicationDataException(String.format("User email '%s' is already exist", userRegisterDto.getEmail()));
        }
        User user = userRepository.save(
                new UserRegisterDtoToUserMapper(passwordFactory).apply(userRegisterDto)
        );
        return user.getId();

    }

    public String changePassword(PasswordUpdatingDto passwordDto) {
        new ObjectsValidator<PasswordUpdatingDto>().apply(passwordDto);

        User user = getUserById(passwordDto.getUserId());

        if (!passwordFactory.isMatched(passwordDto.getCurrentPassword(), user.getPassword())) {
            throw new BadCredentialsException("Current password is incorrect!");
        }

        if (passwordFactory.isMatched(passwordDto.getNewPassword(), user.getPassword())) {
            throw new DuplicationDataException("Current password is same new password!");
        }
        user.setPassword(passwordFactory.encode(passwordDto.getNewPassword()));
        userRepository.save(user);
        return "Password changed successfully.";
    }

    public UserDto getUserDtoById(String id) {
        User user = getUserById(id);
        return new UserToUserDtoMapper()
                .apply(user);
    }

    public UserDto getUserDtoByEmail(String email) {
        User user = loadUserByEmail(email);
        return new UserToUserDtoMapper()
                .apply(user);
    }

    public User loadUserByEmail(String email) throws NoResourceExistException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new NoResourceExistException(String.format("User email '%s' is not found", email)));
    }

    private User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException(String.format("User id '%s' is not found", id))
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Username or Password is incorrect.")
        );
    }
}
