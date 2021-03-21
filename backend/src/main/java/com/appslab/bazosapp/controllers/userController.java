package com.appslab.bazosapp.controllers;

import com.appslab.bazosapp.models.Users;
import com.appslab.bazosapp.services.userService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class userController {
    userService servis;
    public userController( userService servis){
        this.servis=servis;

    }
    @PostMapping("/newuser")
    public void userController(@RequestBody Users user){
        servis.saveUser(user);
    }
}
