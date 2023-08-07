package com.tinoprojects.weatherforecastapp.service;

import com.tinoprojects.weatherforecastapp.UserRepository;
import com.tinoprojects.weatherforecastapp.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test(expected = RuntimeException.class)
    public void testGetUserByUsername_ThrowsNotFoundExceptionIfUserNotFound(){
        String username = "tmuponda";

        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");
//        Mock Behaviour

        Mockito.when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

    }
    @Test(expected = RuntimeException.class)
    public void testGetUserById_ThrowsNotFoundExceptionIfUserNotFound(){
        Long id = 1L;

        User user  = new User();
        user.setId(1L);
        user.setUsername("tmuponda");
        user.setFirstName("Tinotenda");
        user.setLastName("Muponda");
        user.setCity("Harare");
        user.setCountry("Zimbabwe");
//        Mock Behaviour

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty());

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
        assertEquals(user, actualUsers);
        assertEquals(1, actualUsers);
    }


}
