package com.codecool.mavens.controller;

import com.codecool.mavens.entity.User;
import com.codecool.mavens.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return "";
    }

    @PostMapping("/{id}")
    public String addNewUser(@RequestBody User user) {
        return "";
    }

    @PutMapping("/{id}")
    public String updatePersonalInfoByID(@RequestBody User user){
        return "";
    }
}
