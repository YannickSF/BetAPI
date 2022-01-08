package com.cosmos.wibet.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(name = "/")
    public String Hello(){
        return "Hello World";
    }
}
