package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.*;
import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.model.types.Status;
import com.codecool.mavens.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PersonalInfoRepository personalInfoRepository;
    private final ExpertInfoRepository expertInfoRepository;
    private final LocationRepository locationRepository;
    private final ProfessionRepository professionRepository;
    private final ReferenceRepository referenceRepository;
    private final ServiceRepository serviceRepository;
    private final ReviewRepository reviewRepository;

    public List<ExpertCardDto> getAllExpertCards() {
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

    public List<ExpertCardDto> getAllExpertCardsByLocationAndProfession(Long locationId, Long professionId) {
        List<User> foundUsers = userRepository.findByExpertInfoNotNull().stream()
                .filter(user -> user.getExpertInfo().getLocations().stream().anyMatch(location -> location.getId().equals(locationId)))
                .filter(user -> user.getExpertInfo().getProfessions().stream().anyMatch(profession -> profession.getId().equals(professionId)))
                .collect(Collectors.toList());

        return foundUsers.stream().map(ExpertCardDto::new).collect(Collectors.toList());
    }

    public List<User> getAllUsers() {
       return userRepository.findAll();
    }


    public void addNewUser(User user) {
        PersonalInfo personalInfo = personalInfoRepository.saveAndFlush(user.getPersonalInfo());
        Location personalLocation = locationRepository.getById(user.getPersonalInfo().getLocation().getId());

        personalInfo.setLocation(personalLocation);
        personalLocation.getPersonalInfos().add(personalInfo);

        ExpertInfo expertInfo = null;
        if (user.getExpertInfo() != null) {
            // Add Expert Logic
        }

        user.setPersonalInfo(personalInfo);
        user.setExpertInfo(expertInfo);
        userRepository.saveAndFlush(user);
        personalInfoRepository.saveAndFlush(personalInfo);
        locationRepository.saveAndFlush(personalLocation);

    }

}
