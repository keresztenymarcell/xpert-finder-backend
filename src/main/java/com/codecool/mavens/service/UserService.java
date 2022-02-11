package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.*;
import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.model.types.Status;
import com.codecool.mavens.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

        ExpertInfo expertInfoPlaceholder = null;
        if (user.getExpertInfo() != null) {
            ExpertInfo expertInfo = expertInfoRepository.saveAndFlush(user.getExpertInfo());

            Set<Location> workLocations = getWorkLocations(user.getExpertInfo().getLocations());
            workLocations.forEach(location -> location.getExpertInfos().add(expertInfo));

            Set<Profession> professions = getProfessions(user.getExpertInfo().getProfessions());
            professions.forEach(profession -> profession.getExpertInfos().add(expertInfo));


            if (expertInfo.getServices() != null){
                Set<Service> services = expertInfo.getServices();
                services.forEach(service -> service.setExpertInfo(expertInfo));
                serviceRepository.saveAllAndFlush(services);
            }

            if (expertInfo.getReferences() != null) {
                Set<Reference> references = expertInfo.getReferences();
                references.forEach(reference -> reference.setExpertInfo(expertInfo));
                referenceRepository.saveAllAndFlush(references);
            }

            // New Users Can't Have Reviews (here for safekeeping)
            if (expertInfo.getReviews() != null) {
                Set<Review> reviews = expertInfo.getReviews();
                reviews.forEach(review -> review.setExpertInfo(expertInfo));
                reviewRepository.saveAllAndFlush(reviews);
            }

            expertInfoPlaceholder = expertInfo;
        }

        user.setPersonalInfo(personalInfo);
        user.setExpertInfo(expertInfoPlaceholder);
        userRepository.saveAndFlush(user);
    }

    private Set<Profession> getProfessions(Set<Profession> professions) {
        Set<Profession> dbProfessions = new HashSet<>();
        professions.forEach(profession -> dbProfessions.add(professionRepository.getById(profession.getId())));
        return dbProfessions;
    }

    private Set<Location> getWorkLocations(Set<Location> locations) {
        Set<Location> dbLocations = new HashSet<>();
        locations.forEach(location -> dbLocations.add(locationRepository.getById(location.getId())));
        return dbLocations;
    }
}
