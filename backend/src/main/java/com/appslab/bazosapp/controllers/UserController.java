package com.appslab.bazosapp.controllers;

import com.appslab.bazosapp.dto.UserRegistrationDto;
import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping

public class UserController {
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
    public Users getUser(){
        return servis.getCurrentUser();
    }
    @PostMapping("/saveuser")
    public void saveUser(@RequestBody UserRegistrationDto userRegistrationDto){
        servis.save(userRegistrationDto);
    }



}
