package com.appslab.bazosapp.services;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Role;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {


    private PasswordEncoder encoder;
    private UserRepository userRepository;

    public UserServiceImpl() {

    }

    public UserServiceImpl(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public Users save(UserRegistrationDto registrationDto) {

        Users user = new Users();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setAddress(registrationDto.getAddress());
        user.setRole(Role.USER);
        user.setCity(registrationDto.getCity());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(encoder.encode(registrationDto.getPassword()));
        user.setState(registrationDto.getState());
        user.setPhoneNumber(registrationDto.getPhoneNumber());
        return userRepository.save(user);

    }

    @Override
    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Long getUserId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        Optional<Users> user = userRepository.findByEmail(email);
        return user.get().getId();
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public Users getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        String email = userDetails.getUsername();
        return this.userRepository.findByEmail(email).orElseThrow();
    }

}

