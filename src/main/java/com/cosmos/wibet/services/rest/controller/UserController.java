package com.cosmos.wibet.services.rest.controller;

import com.cosmos.wibet.services.domain.UserService;
import com.cosmos.wibet.services.model.User;
import com.cosmos.wibet.services.rest.model.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User creatUser(@RequestBody UserRest userRest){
        return userService.createUser(userRest);
    }

    @GetMapping
    public User getUser(@RequestBody UserRest userRest){
        return userService.getUser(userRest);
    }

}
