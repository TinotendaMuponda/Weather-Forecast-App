package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.UserRepository;
import com.tinoprojects.weatherforecastapp.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
