package com.appslab.bazosapp.services;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Role;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {



    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public  Users save(UserRegistrationDto registrationDto){

        Users user = new Users();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setAddress(registrationDto.getAddress());
        user.setRole(Role.USER);
        user.setCity(registrationDto.getCity());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        return userRepository.save(user);

    }
}
