package com.codecool.mavens.controller;

import com.codecool.mavens.model.dto.ExpertCardDto;
import com.codecool.mavens.model.dto.ExpertProfileDto;
import com.codecool.mavens.model.dto.ImportantInfoDto;
import com.codecool.mavens.model.dto.RegisterForm;
import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/expert-profile")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ExpertProfileDto getExpertInfoById(@PathVariable Long id) {
        return  userService.getExpertInfo(id);
    }

    @GetMapping("/{id}/expert-card")
    public ExpertCardDto getExertCardById(@PathVariable Long id){
        return userService.getExpertCard(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User getUserById(@PathVariable Long id){
        return userService.getUserByID(id);
    }

    @GetMapping("/username/{username}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public User getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/save-all")
    public String saveAll(@RequestBody List<User> users){
        for (User user : users) {
            userService.addNewUser(user);
        }
        return "users added";
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "User Updated";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterForm registerForm) {
        if(userService.registerUser(registerForm)){
            return ResponseEntity.ok("Successful Registration");
        }else{
            return ResponseEntity.badRequest().body("Username already in use");
        }

    }

    @PostMapping("/personal")
    public String personalInfo(@RequestBody PersonalInfo info){
        System.out.println(info);
        return "";
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

    @GetMapping("/search-all")
    public List<ExpertCardDto> getAllExpertByProfessionAndLocationTrial(){
        return userService.getAllExpertCards();
    }

    @GetMapping("/search")
    public List<ExpertCardDto> getAllExpertByProfessionAndLocation(@RequestParam(name = "location-id") Long locationID,
                                                          @RequestParam(name = "profession-id") Long professionID){
        return userService.getAllExpertCardsByLocationAndProfession(locationID, professionID);
    }

    @GetMapping("/get-important-info")
    public ImportantInfoDto getImportantInfo(@RequestParam("username")String username) {
        return userService.getImportantInfo(username);
    }
}
