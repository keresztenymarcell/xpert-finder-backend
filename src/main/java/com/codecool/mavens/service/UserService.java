package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.*;
import com.codecool.mavens.model.entity.ExpertInfo;
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

    public void addNewUser(User user){

        Set<Location> locations = user.getExpertInfo().getLocations();
        for (Location item : locations) {
            item.setExpertInfos(setExpertInfoToLocation(item, user));
        }

        userRepository.save(user);
    }

    private Set<ExpertInfo> setExpertInfoToLocation(Location location, User user){
        Set<ExpertInfo> set = locationRepository.getById(location.getId()).getExpertInfos();
        set.add(user.getExpertInfo());
        return set;
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
}
