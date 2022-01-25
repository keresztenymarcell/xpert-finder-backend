package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.*;
import com.codecool.mavens.model.entity.Location;
import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.types.Status;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.repository.LocationRepository;
import com.codecool.mavens.repository.PersonalInfoRepository;
import com.codecool.mavens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PersonalInfoRepository personalInfoRepository;

    @Autowired
    LocationRepository locationRepository;

    public List<ExpertCardDto> getAll() {
        return userRepository.findByExpertInfoNotNull().stream().map(ExpertCardDto::new).collect(Collectors.toList());
    }

    public User getUserByID(Long id){
        return userRepository.getById(id);
    }

    public ExpertProfileDto getExpertInfo(Long id){
        return  new ExpertProfileDto(userRepository.getById(id));
    }

    public ExpertCardDto getExpertCard(Long id){
        return new ExpertCardDto(userRepository.getById(id));
    }

    public void addNewUser(RegisterForm form){
        String username = form.getUsername();
        String name = form.getName();
        String password = form.getPassword();
        String email = form.getEmailAddress();
        String confirmPassword = form.getConfirmPassword();
        Long locationID =  form.getLocationID();
        String phoneNumber = form.getPhoneNumber();

        //TODO: Validate is username doesn't exists in db and password match too
        Location location = locationRepository.findById(locationID).orElse(null);

        User user = User.builder()
                .personalInfo(PersonalInfo.builder()
                                .username(username)
                                .name(name)
                                .password(password)
                                .email(email)
                                .location(location)
                                .phoneNumber(phoneNumber)
                                .status(Status.ACTIVE)
                                .build())
                .registrationTime(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    public boolean authenticateUser(UserLoginData data){
        String inputUsername = data.getUsername();
        String inputPassword = data.getPassword();
        String expectedPassword = personalInfoRepository.findByUsername(inputUsername).getPassword();

        return inputPassword.equals(expectedPassword);
    }

    public void deleteUser(Long id) {
        User user = userRepository.getById(id);
        user.getPersonalInfo().setStatus(Status.INACTIVE);
        userRepository.save(user);
    }

    public List<User> getAllUsersByLocationAndProfession(Long locationId, Long professionId) {
        return null;
        /*return userRepository.findAllByLocationId(locationId, professionId);*/
    }
}
