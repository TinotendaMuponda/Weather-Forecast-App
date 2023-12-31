package com.tinoprojects.weatherforecastapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {

    private String username;
    private String password;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    private String country;
    private String city;

    @Enumerated(EnumType.STRING)
    private Role role;

}
