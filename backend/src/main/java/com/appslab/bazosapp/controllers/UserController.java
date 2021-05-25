package com.appslab.bazosapp.controllers;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Items;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.repositories.UserRepository;
import com.appslab.bazosapp.services.ItemService;
import com.appslab.bazosapp.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping

public class UserController {
    @Autowired
    UserRepository repo;
    UserService servis;

    public UserController(UserService servis){
        this.servis=servis;

    }

    @GetMapping("/detailuserid/{id}")

    public Optional<Users> detailUserId(@PathVariable long id) {
        return servis.getUserById(id); }

    @GetMapping("/detailuser/{email}")

    public Optional<Users> detailUser(@PathVariable String email) { return servis.getUserByEmail(email); }
    @GetMapping("/user")
    public void getUser(){
    }
    @PostMapping("/saveuser")
    public void saveUser(@RequestBody UserRegistrationDto userRegistrationDto){
        servis.save(userRegistrationDto);
    }



}
