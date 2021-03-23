package com.appslab.bazosapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Users {
    @Id
    String firstName;
    String lastName;

    @OneToMany
    Set<Items>items;
}
