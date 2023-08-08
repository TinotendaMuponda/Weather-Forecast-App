package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.domain.*;
import com.tinoprojects.weatherforecastapp.exception.ResourceNotFoundException;
import com.tinoprojects.weatherforecastapp.repository.UserRepository;
import com.tinoprojects.weatherforecastapp.utility.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserCreateDTO user) {
        User createdUser = new User();
        createdUser.setCity(user.getCity());
        createdUser.setCountry(user.getCountry());
        createdUser.setUsername(user.getUsername());
        createdUser.setFirstName(user.getFirstName());
        createdUser.setLastName(user.getLastName());
//        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setRole(Role.USER);
        return userRepository.save(createdUser);
    }

    @Override
    public AuthToken login(Login login) {
        User loginUser = userRepository.findByUsername(login.getUsername())
                .orElseThrow(()->new ResourceNotFoundException("No Account Associated with the user: "+login.getUsername()));
        AuthToken token = new AuthToken();
        log.info("username {}, password {}",login.getUsername(), login.getPassword());
        authenticate(login.getUsername(), login.getPassword());
        UserPrincipal userPrincipal = new UserPrincipal(loginUser);
        String jwtToken = jwtTokenProvider.generateJwtToken(userPrincipal);
        token.setToken(jwtToken);
        return token;
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
