package com.sirius1b.auth.services;

import com.sirius1b.auth.exceptions.TokenNotFoundException;
import com.sirius1b.auth.exceptions.UserNotFoundException;
import com.sirius1b.auth.models.Token;
import com.sirius1b.auth.models.User;
import com.sirius1b.auth.repos.TokenRepository;
import com.sirius1b.auth.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private TokenRepository tokenRepository;

    public UserService(UserRepository userRepository, TokenRepository tokenRepository){
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public User signup(String name,
                       String email,
                       String password){

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setHashedPassword(password);

        return userRepository.save(user);
    }

    public Token login(String email, String password) throws UserNotFoundException {

        User user  = userRepository.findByEmail(email).orElse(null);

        if (user == null){
            throw new UserNotFoundException("User not found by email: " + email);
        }

        // todo: password validation

        Token token = new Token();
        token.setUser(user);
        token.setValue(getToken());
        token.setExpiryAt(System.currentTimeMillis() + 1000*3600*12*30);

        tokenRepository.save(token);
        return token;
    }

    private String getToken(){
        return "121423"; // jwt token here
    }

    public void logout (String value) throws TokenNotFoundException {

        Token token = tokenRepository.findByValue(value).orElse(null);

        if (token == null){
            throw new TokenNotFoundException("Token Not Found");
        }

        tokenRepository.delete(token);
    }
}
