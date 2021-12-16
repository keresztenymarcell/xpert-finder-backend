package com.codecool.mavens.controller;


import com.codecool.mavens.model.dto.UserLoginData;
import com.codecool.mavens.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping()
    public String authenticateUser(@RequestBody UserLoginData data){
        String response;
        if(userService.authenticateUser(data)){
            response = "User logged in!";
        }
        else{
            response = "Invalid username or password!";
        }

        return response;
    }
}
