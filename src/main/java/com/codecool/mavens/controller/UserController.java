package com.codecool.mavens.controller;

import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "";
    }

    @PostMapping("/{id}")
    public String addNewUser(@RequestBody User user) {
        return "";
    }

    @PutMapping("/{id}")
    public String updatePersonalInfoByID(@PathVariable Long id, @RequestBody PersonalInfo user){
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return "";
    }

    @GetMapping("/search")
    public List<User> getAllExpertByProfessionAndLocation(@RequestParam(name = "location-id") Long locationID,
                                                          @RequestParam(name = "profession-id") Long professionID){

        //Call the service which returns the ordered list of searched Users.
        return null;
    }
}
