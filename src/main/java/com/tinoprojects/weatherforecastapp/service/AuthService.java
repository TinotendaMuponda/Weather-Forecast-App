package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.domain.AuthToken;
import com.tinoprojects.weatherforecastapp.domain.Login;
import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.domain.UserCreateDTO;

public interface AuthService {
    public User registerUser(UserCreateDTO user);
    public AuthToken login(Login login);

}
