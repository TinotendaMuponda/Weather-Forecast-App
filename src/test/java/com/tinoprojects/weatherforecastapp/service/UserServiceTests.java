package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.UserRepository;
import com.tinoprojects.weatherforecastapp.domain.User;
import com.tinoprojects.weatherforecastapp.exception.ResourceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(value = MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testCreateUser(){
        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");
//        Mock Behaviour

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User actualUser = userService.createUser(user);

        assertNotNull(actualUser);
        assertEquals(user, actualUser);
    }

    @Test
    public void testGetUserByUsername(){
        String username = "tmuponda";

        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");
//        Mock Behaviour

        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        User actualUser = userService.getUserByUsername(username);

        assertNotNull(actualUser);
        assertEquals(user, actualUser);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetUserByUsername_ThrowsNotFoundExceptionIfUserNotFound(){
        String username = "tmuponda";

        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, ()-> userService.getUserByUsername(username));


    }
    @Test(expected = ResourceNotFoundException.class)
    public void testGetUserById_ThrowsNotFoundExceptionIfUserNotFound(){
        Long id = 2L;

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, ()-> userService.getUserById(id));

    }

    @Test
    public void testGetUsers(){
        Long id = 1L;

        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");
//        Mock Behaviour

        Mockito.when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> actualUsers = userService.getUsers();

        assertNotNull(actualUsers);
        assertEquals(List.of(user), actualUsers);
        assertEquals(1, actualUsers.size());
    }


}
