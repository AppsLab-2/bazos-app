package com.appslab.bazosapp.services;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Users;



public interface UserService {

    Users save(UserRegistrationDto registrationDto);

}
