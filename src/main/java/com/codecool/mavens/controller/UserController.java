package com.codecool.mavens.controller;

import com.codecool.mavens.model.dto.ExpertCardDto;
import com.codecool.mavens.model.dto.ExpertProfileDto;
import com.codecool.mavens.model.dto.RegisterForm;
import com.codecool.mavens.model.dto.ExpertInfoDto;
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


    @GetMapping("/{id}/expert-profile")
    public ExpertProfileDto getExpertInfoById(@PathVariable Long id) {
        return  userService.getExpertInfo(id);
    }

    @GetMapping("/{id}/expert-card")
    public ExpertCardDto getExertCardById(@PathVariable Long id){
        return userService.getExpertCard(id);
    }

    @GetMapping("/trial-1")
    public String getUserByIdTrial() {
        return "{\"id\":1,\"personalInfo\":{\"id\":12,\"location\":{\"id\":13,\"name\":\"Budapest\"},\"username\":\"trialT\",\"name\":\"Trial Tibor\",\"email\":\"tibor.trial@gmail.com\",\"phoneNumber\":\"222-444\",\"status\":\"active\",\"role\":\"user\",\"profilePicture\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.redd.it%2Fxjmijhw09dm11.jpg&f=1&nofb=1\"},\"expertInfo\":{\"description\":\"I am a professional dog-walker. Don't worry, you won't regret contacting me! ;)\",\"id\":8,\"rating\":3,\"jobCount\":7,\"reference\":[{\"id\":89,\"description\":\"A nice dog I've walked\",\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1\"}],\"professions\":[{\"name\":\"Dog Walker\",\"category\":{\"name\":\"Around the House Jobs\",\"id\":77}}],\"locations\":[{\"id\":13,\"name\":\"Budapest\"},{\"id\":88,\"name\":\"Dubai\"}]},\"reviews\":[{\"id\":1,\"reviewer\":{\"id\":1,\"username\":\"trialT\"},\"message\":\"He was very nice to mydog, would recommend 10/10!!!\",\"rating\":1,\"time\":\"2022-01-13T18:42:41.685216\"},{\"id\":2,\"reviewer\":{\"id\":55,\"username\":\"randomN00b\"},\"message\":\"He bit me!! never contacting him again!!\",\"rating\":5,\"time\":\"2022-01-07T18:42:41.685216\"}],\"services\":[{\"id\":1,\"name\":\"Dog walking-30min\",\"price\":\"3000Ft\",\"description\":\"I walk your dog like a pro for half an hour\"},{\"id\":2,\"name\":\"Dog walking-60min\",\"price\":\"5500Ft\",\"description\":\"I walk your dog like a pro for an hour\"}],\"registrationTime\":\"2022-01-13T10:42:49.685216\",\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"}";
    }

    @GetMapping("/trial-2")
    public String getUserByIdTrial2() {
        return "{\"id\":2,\"personalInfo\":{\"id\":1213,\"location\":{\"id\":13,\"name\":\"Budapest\"},\"username\":\"BestOfProfessional1212\",\"name\":\"Szabó Gábor József\",\"email\":\"szabojozsef@gmail.com\",\"phoneNumber\":\"333-234\",\"status\":\"active\",\"role\":\"user\",\"profilePicture\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fhandsome-man-touching-his-chin-picture-id838654882%3Fk%3D6%26m%3D838654882%26s%3D170667a%26w%3D0%26h%3DC71D1iPkkB9J616JR_-qPFiBpFeRoOEylohvI780Q24%3D&f=1&nofb=1\"},\"expertInfo\":{\"description\":\"I have been in my profession for 10 years. I am the best in the business\",\"id\":8,\"rating\":5,\"jobCount\":54,\"reference\":[{\"id\":1,\"description\":\"Little Billy enjoying my lesson after getting an eye surgery\",\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.kidsguitarworld.com%2Fwp-content%2Fuploads%2F2015%2F11%2FKid-playing-guitar.jpg&f=1&nofb=1\"}],\"professions\":[{\"name\":\"Guitar teaching\",\"category\":{\"name\":\"Music\",\"id\":78}},{\"name\":\"Eye Surgeon\",\"category\":{\"name\":\"Health\",\"id\":79}}],\"locations\":[{\"id\":13,\"name\":\"Budapest\"}]},\"services\":[{\"id\":1,\"name\":\"Guitar teaching\",\"price\":\"13000Ft/hour\",\"description\":\"Intense teaching of Jazz-guitar\"},{\"id\":2,\"name\":\"Eye Surgery\",\"price\":\"40000Ft\",\"description\":\"From sight-enhancement to removal\"}],\"reviews\":[],\"registrationTime\":\"2022-01-13T10:42:49.685216\",\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"}";    }
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
        return  "[{\"id\":1,\"personalInfo\":{\"id\":12,\"location\":{\"id\":13,\"name\":\"Budapest\"},\"username\":\"trialT\",\"name\":\"Trial Tibor\",\"email\":\"tibor.trial@gmail.com\",\"phoneNumber\":\"222-444\",\"status\":\"active\",\"role\":\"user\",\"profilePicture\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.redd.it%2Fxjmijhw09dm11.jpg&f=1&nofb=1\"},\"expertInfo\":{\"description\":\"I am a professional dog-walker. Don't worry, you won't regret contacting me! ;)\",\"id\":2,\"rating\":3,\"jobCount\":7,\"reference\":[{\"id\":89,\"description\":\"A nice dog I've walked\",\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1\"}],\"professions\":[{\"name\":\"Dog Walker\",\"category\":{\"name\":\"Around the House Jobs\",\"id\":77}}],\"locations\":[{\"id\":13,\"name\":\"Budapest\"},{\"id\":88,\"name\":\"Dubai\"}]},\"reviews\":[{\"id\":1,\"reviewer\":{\"id\":1,\"username\":\"trialT\"},\"message\":\"He was very nice to mydog, would recommend 10/10!!!\",\"rating\":1,\"time\":\"2022-01-13T18:42:41.685216\"},{\"id\":2,\"reviewer\":{\"id\":55,\"username\":\"randomN00b\"},\"message\":\"Hebitme!!nevercontactinghimagain!!\",\"rating\":5,\"time\":\"2022-01-07T18:42:41.685216\"}],\"services\":[{\"id\":1,\"name\":\"Dogwalking-30min\",\"price\":\"3000Ft\",\"description\":\"Iwalkyourdoglikeaproforhalfanhour\"},{\"id\":2,\"name\":\"Dogwalking-60min\",\"price\":\"5500Ft\",\"description\":\"Iwalkyourdoglikeaproforanhour\"}],\"registrationTime\":\"2022-01-13T10:42:49.685216\",\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"},{\"id\":2,\"personalInfo\":{\"id\":1213,\"location\":{\"id\":13,\"name\":\"Budapest\"},\"username\":\"BestOfProfessional1212\",\"name\":\"Szabó Gábor József\",\"email\":\"szabojozsef@gmail.com\",\"phoneNumber\":\"333-234\",\"status\":\"active\",\"role\":\"user\",\"profilePicture\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fhandsome-man-touching-his-chin-picture-id838654882%3Fk%3D6%26m%3D838654882%26s%3D170667a%26w%3D0%26h%3DC71D1iPkkB9J616JR_-qPFiBpFeRoOEylohvI780Q24%3D&f=1&nofb=1\"},\"expertInfo\":{\"description\":\"I have been in my profession for 10 years. I am the best in the business\",\"id\":8,\"rating\":5,\"jobCount\":54,\"reference\":[{\"id\":1,\"description\":\"Little Billy enjoying my lesson after getting an eye surgery\",\"imagePath\":\"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.kidsguitarworld.com%2Fwp-content%2Fuploads%2F2015%2F11%2FKid-playing-guitar.jpg&f=1&nofb=1\"}],\"professions\":[{\"name\":\"Guitar teaching\",\"category\":{\"name\":\"Music\",\"id\":78}},{\"name\":\"Eye Surgeon\",\"category\":{\"name\":\"Health\",\"id\":79}}],\"locations\":[{\"id\":13,\"name\":\"Budapest\"}]},\"services\":[{\"id\":1,\"name\":\"Guitar teaching\",\"price\":\"13000Ft/hour\",\"description\":\"Intense teaching of Jazz-guitar\"},{\"id\":2,\"name\":\"Eye Surgery\",\"price\":\"40000Ft\",\"description\":\"From sight-enhancement to removal\"}],\"reviews\":[],\"registrationTime\":\"2022-01-13T10:42:49.685216\",\"lastLoginTime\":\"2022-01-17T10:42:49.685216\"}]";    }

}
