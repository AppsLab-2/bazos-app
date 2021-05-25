package com.appslab.bazosapp.services;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Users;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.Optional;
import java.util.Set;


public interface UserService {

    Users save(UserRegistrationDto registrationDto);
    Optional<Users> getUserByEmail(String email);
    Long getUserId();
    Optional <Users>getUserById(Long id);

}
