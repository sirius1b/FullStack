package com.sirius1b.auth.controllers;


import com.sirius1b.auth.dtos.*;
import com.sirius1b.auth.exceptions.CredentialException;
import com.sirius1b.auth.exceptions.RoleNotFoundException;
import com.sirius1b.auth.exceptions.TokenNotFoundException;
import com.sirius1b.auth.exceptions.UserNotFoundException;
import com.sirius1b.auth.models.Token;
import com.sirius1b.auth.models.User;
import com.sirius1b.auth.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignupRespDto signup(@RequestBody  SignupDto request) throws RoleNotFoundException {
        log.info(request.toString());
        User user =  userService.signup( request.getName(),
                                    request.getEmail(),
                                    request.getPassword());

        return SignupRespDto.from(user);
    }

    @PostMapping("/login")
    public TokenRespDto login(@RequestBody LoginDto request) throws UserNotFoundException, CredentialException {
        log.info(request.toString());
        Token token = userService.login(request.getEmail(), request.getPassword());
        return TokenRespDto.from(token);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody LogoutDto req ) throws TokenNotFoundException {
        log.info(req.toString());
        userService.logout(req.getToken());
    }


}
