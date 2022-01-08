package com.cosmos.wibet.rest.controller;

import com.cosmos.wibet.domain.services.UserService;
import com.cosmos.wibet.domain.model.User;
import com.cosmos.wibet.rest.model.UserRest;
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
