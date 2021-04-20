package com.appslab.bazosapp.services;

import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository repositor;
    public UserServiceImpl(UserRepository repositor){
        this.repositor=repositor;
    }
    @Override
    public  void saveUser(Users user){
        repositor.save(user);
    }
}
