package com.tinoprojects.weatherforecastapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User extends BaseEntity {

    private String username;
    private String firstName;
    private String lastName;
    private String country;
    private String city;


}
