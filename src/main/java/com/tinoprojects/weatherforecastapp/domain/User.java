package com.tinoprojects.weatherforecastapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String firstName;
    private String lastName;
    private String country;
    private String city;

}
