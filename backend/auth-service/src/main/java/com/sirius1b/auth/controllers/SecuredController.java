package com.sirius1b.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecuredController {

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello Secure World!";
    }

}
