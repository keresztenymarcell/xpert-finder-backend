package com.codecool.mavens.service;

import com.codecool.mavens.controller.UserController;
import com.codecool.mavens.model.dto.RegisterForm;
import com.codecool.mavens.model.dto.UserLoginData;
import com.codecool.mavens.model.entity.Location;
import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.entity.Status;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.repository.LocationRepository;
import com.codecool.mavens.repository.PersonalInfoRepository;
import com.codecool.mavens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PersonalInfoRepository personalInfoRepository;

    @Autowired
    LocationRepository locationRepository;

    public User getUserByID(Long id){
        return userRepository.getById(id);
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
}
