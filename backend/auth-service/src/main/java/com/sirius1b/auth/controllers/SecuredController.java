package com.sirius1b.auth.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecuredController {

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello Secure World! - ADMIN";
    }


    @GetMapping("/user")
    public String helloUser(){
        return "Hello Secure World! - USER";
    }

}
