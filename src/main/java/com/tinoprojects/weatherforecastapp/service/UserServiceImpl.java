package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.domain.UserPrincipal;
import com.tinoprojects.weatherforecastapp.repository.UserRepository;
import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService, UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("User with username not Found"));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Username with ID not Found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new ResourceNotFoundException("No User Associated with username: " + username));
        return new UserPrincipal(user);
    }
}
