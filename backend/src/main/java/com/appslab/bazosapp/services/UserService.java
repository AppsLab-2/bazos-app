package com.appslab.bazosapp.services;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Users;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


public interface UserService {

    Users save(UserRegistrationDto registrationDto);
    Optional<Users> getUserByEmail(String email);

}
