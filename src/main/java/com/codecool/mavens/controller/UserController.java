package com.codecool.mavens.controller;

import com.codecool.mavens.model.dto.RegisterForm;
import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserByID(id);
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody RegisterForm form) {
        userService.addNewUser(form);
        return "User added!";
    }

    @PutMapping("/{id}")
    public String updatePersonalInfoByID(@PathVariable Long id, @RequestBody PersonalInfo user){
        //TODO: implement service method
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "User deleted!";

    }

    @CrossOrigin("*")
    @GetMapping("/search-trial")
    public List<User> getAllExpertByProfessionAndLocationTrial(){
        return userService.getAll();
    }

    @GetMapping("/search")
    public List<User> getAllExpertByProfessionAndLocation(@RequestParam(name = "location") Long locationID,
                                                          @RequestParam(name = "profession") Long professionID){
        System.out.println("location Id: " + locationID + ", profession Id: " + professionID);
        //TODO: Call the service which returns the ordered list of searched Users.
        return userService.getAllUsersByLocationAndProfession(locationID, professionID);
    }

    @PostMapping("/search")
    public String afsdfa(@RequestBody String x) {
        System.out.println(x);
        return "good";
    }

}
