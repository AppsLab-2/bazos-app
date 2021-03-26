package com.appslab.bazosapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @Column(name = "userinfo")
    String nickname;
    String firstName;
    String lastName;



    @OneToMany(mappedBy = "users")
    private Set<Items>items;
    public Users(String nickname,String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Users() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
