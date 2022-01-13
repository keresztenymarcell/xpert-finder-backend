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

    @GetMapping("/trial/{id}")
    public String getUserByIdTrial(@PathVariable Long id) {
        return "{\"id\":7," +
                "\"personalInfo\":{" +
                "\"id\":12,\"location\":{" +
                "\"id\":13,\"name\":\"Budapest\"}," +
                "\"username\":\"trialT\"," +
                "\"name\":\"TrialTibor\"," +
                "\"email\":\"tibor.trial@gmail.com\"," +
                "\"phoneNumber\":\"222-444\"," +
                "\"status\":\"active\"," +
                "\"role\":\"user\", }," +
                "\"profilePicture\":\"profile/picture.jpg\"" +
                "\"expertInfo\":{" +
                "\"description\":\"I make very nice pictures of dogs.\"" +
                "\"id\":8," +
                "\"rating\":3," +
                "\"jobCount\":7," +
                "\"reference\":[{" +
                "\"id\":89," +
                "\"description\":\"A nice dog I've walked\"," +
                "\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1\"" +
                "}]," +
                "\"professions\":[{" +
                "\"name\":\"Kutyasétáltató\"," +
                "\"category\":{\"name\":" +
                "\"Ház körüli munkák\"," +
                "\"id\":77}}]," +
                "\"locations\":[{" +
                "\"id\":13," +
                "\"name\":\"Budapest\"}," +
                "{\"id\":88," +
                "\"name\":\"Dubai\"}]}," +
                "\"registrationTime\":\"2022-01-13T10:42:49.685216\"," +
                "\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"}";
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

/*    @GetMapping("/search")
    public List<User> getAllExpertByProfessionAndLocation(@RequestParam(name = "location") Long locationID,
                                                          @RequestParam(name = "profession") Long professionID){
        System.out.println("location Id: " + locationID + ", profession Id: " + professionID);
        //TODO: Call the service which returns the ordered list of searched Users.
        return userService.getAllUsersByLocationAndProfession(locationID, professionID);
    }*/

    @GetMapping("/search-all-trial")
    public String afsdfa() {
        return  "[{\"id\":7," +
                "\"personalInfo\":{" +
                "\"id\":12,\"location\":{" +
                "\"id\":13,\"name\":\"Budapest\"}," +
                "\"username\":\"trialT\"," +
                "\"name\":\"TrialTibor\"," +
                "\"email\":\"tibor.trial@gmail.com\"," +
                "\"phoneNumber\":\"222-444\"," +
                "\"status\":\"active\"," +
                "\"role\":\"user\"," +
                "\"profilePicture\":\"profile/picture.jpg\"," +
                "\"expertInfo\":{" +
                "\"description\":\"I make very nice pictures of dogs.\"," +
                "\"id\":8," +
                "\"rating\":3," +
                "\"jobCount\":7," +
                "\"reference\":[{" +
                "\"id\":89," +
                "\"description\":\"A nice dog I've walked\"," +
                "\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1\"" +
                "}]," +
                "\"professions\":[{" +
                "\"name\":\"Kutyasétáltató\"," +
                "\"category\":{\"name\":" +
                "\"Ház körüli munkák\"," +
                "\"id\":77}}]," +
                "\"locations\":[{" +
                "\"id\":13," +
                "\"name\":\"Budapest\"}," +
                "{\"id\":88," +
                "\"name\":\"Dubai\"}]}," +
                "\"registrationTime\":\"2022-01-13T10:42:49.685216\"," +
                "\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"}}," +
                // Second User
                "{\"id\":8," +
                "\"personalInfo\":{" +
                "\"id\":12,\"location\":{" +
                "\"id\":13,\"name\":\"Budapest\"}," +
                "\"username\":\"trialT\"," +
                "\"name\":\"TrialTibor\"," +
                "\"email\":\"tibor.trial@gmail.com\"," +
                "\"phoneNumber\":\"222-444\"," +
                "\"status\":\"active\"," +
                "\"role\":\"user\"," +
                "\"profilePicture\":\"profile/picture.jpg\"," +
                "\"expertInfo\":{" +
                "\"description\":\"I make very nice pictures of dogs.\"," +
                "\"id\":8," +
                "\"rating\":3," +
                "\"jobCount\":7," +
                "\"reference\":[{" +
                "\"id\":89," +
                "\"description\":\"A nice dog I've walked\"," +
                "\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1\"" +
                "}]," +
                "\"professions\":[{" +
                "\"name\":\"Kutyasétáltató\"," +
                "\"category\":{\"name\":" +
                "\"Ház körüli munkák\"," +
                "\"id\":77}}]," +
                "\"locations\":[{" +
                "\"id\":13," +
                "\"name\":\"Budapest\"}," +
                "{\"id\":88," +
                "\"name\":\"Dubai\"}]}," +
                "\"registrationTime\":\"2022-01-13T10:42:49.685216\"," +
                "\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"}}]";
    }

}
