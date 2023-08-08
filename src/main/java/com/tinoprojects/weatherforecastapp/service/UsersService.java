package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.domain.User;

import java.util.List;

public interface UsersService {

    public User createUser(User user);
    public List<User> getUsers();
    public  User getUserByUsername(String username);
    public User getUserById(Long id);
    public User changePreferedLocation(String country, String city);

}
