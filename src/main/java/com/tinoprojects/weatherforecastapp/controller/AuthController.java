package com.tinoprojects.weatherforecastapp.controller;

import com.tinoprojects.weatherforecastapp.domain.AuthToken;
import com.tinoprojects.weatherforecastapp.domain.Login;
import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.domain.UserCreateDTO;
import com.tinoprojects.weatherforecastapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(UserCreateDTO user){
        return new ResponseEntity<>(authService.registerUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthToken> login(Login login){
        return new ResponseEntity<>(authService.login(login), HttpStatus.OK);
    }
}
