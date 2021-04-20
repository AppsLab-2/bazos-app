package com.appslab.bazosapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @Column(name = "userinfo")
    String firstname;
    String lastname;
    String email;
    String address;
    String city;
    String state;
    String number;


    @OneToMany(mappedBy = "users")
    private Set<Items> items;
}
