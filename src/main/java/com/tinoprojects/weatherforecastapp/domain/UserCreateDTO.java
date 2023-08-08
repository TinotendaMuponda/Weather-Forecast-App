package com.tinoprojects.weatherforecastapp.domain;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
}
