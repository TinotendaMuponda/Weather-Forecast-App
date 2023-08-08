package com.tinoprojects.weatherforecastapp.controller;

import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<User> createUser(User user){
        return new ResponseEntity<>(usersService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return  ResponseEntity.ok(usersService.getUsers());
    }

    @GetMapping("/id")
    public ResponseEntity<User> getUserById(Long id){
        return  ResponseEntity.ok(usersService.getUserById(id));
    }

    @GetMapping(params = {"username"})
    public ResponseEntity<User> getUserByUsername(@RequestParam String username){
        return  ResponseEntity.ok(usersService.getUserByUsername(username));
    }

    @PutMapping(value = "/location",params = {"country", "city"})
    public ResponseEntity<User> changePreferredLocation(@RequestParam String country, @RequestParam String city){
        return  ResponseEntity.ok(usersService.changePreferedLocation(country, city));
    }


}
