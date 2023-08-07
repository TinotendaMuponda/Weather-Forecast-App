package com.tinoprojects.weatherforecastapp.controller;

import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.service.UserServiceImpl;
import com.tinoprojects.weatherforecastapp.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTests {

    @Mock
    private UsersService usersService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetUsers(){

//        arrange
        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");

//        mock
        Mockito.when(usersService.getUsers()).thenReturn(List.of(user));

//        act
        ResponseEntity<List<User>> actualResponse = userController.getUsers();

//        assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(List.of(user), actualResponse.getBody());

    }

    @Test
    public void testCreateUser(){

//        arrange
        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");

//        mock
        Mockito.when(usersService.createUser(user)).thenReturn(user);

//        act
        ResponseEntity<User> actualResponse = userController.createUser(user);

//        assert
        assertEquals(HttpStatus.CREATED, actualResponse.getStatusCode());
        assertEquals(user, actualResponse.getBody());

    }

    @Test
    public void testGetUserById(){

        Long id = 1L;

//        arrange
        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");

//        mock
        Mockito.when(usersService.getUserById(id)).thenReturn(user);

//        act
        ResponseEntity<User> actualResponse = userController.getUserById(id);

//        assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(user, actualResponse.getBody());

    }

    @Test
    public void testGetUserByUsername(){

        String username = "tmuponda";

//        arrange
        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");

//        mock
        Mockito.when(usersService.getUserByUsername(username)).thenReturn(user);

//        act
        ResponseEntity<User> actualResponse = userController.getUserByUsername(username);

//        assert
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(user, actualResponse.getBody());

    }
}
