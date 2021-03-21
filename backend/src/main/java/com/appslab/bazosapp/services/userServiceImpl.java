package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.repositories.userRepository;

public class userServiceImpl implements userService{
    userRepository repositor;
    public userServiceImpl(userRepository repositor){
        this.repositor=repositor;
    }
    @Override
    public  void saveUser(Users user){
        repositor.save(user);
    }
}
