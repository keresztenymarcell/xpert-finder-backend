package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.*;
import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.model.types.Status;
import com.codecool.mavens.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Ref;
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

    @Autowired
    ProfessionRepository professionRepository;

    @Autowired
    ReferenceRepository referenceRepository;

    @Autowired
    ServiceRepository serviceRepository;

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

    public void addNewUser(User user) {
        saveUpdatedUser(user);
    }


    public void updateUser(User updatedUser){
        userRepository.save(updatedUser);
    }

    public void updatePersonalInfo(User user, User updatedUser){
        Long locationId = updatedUser.getPersonalInfo().getLocation().getId();
        PersonalInfo info = user.getPersonalInfo();
        PersonalInfo updatedInfo = updatedUser.getPersonalInfo();

        info.setEmail(updatedInfo.getEmail());
        info.setName(updatedInfo.getName());
        info.setPassword(updatedInfo.getPassword());
        info.setPhoneNumber(updatedInfo.getPhoneNumber());
        info.setProfilePicture(updatedInfo.getProfilePicture());
        info.setUsername(updatedInfo.getUsername());
        info.setLocation(locationRepository.getById(locationId));

        user.setPersonalInfo(info);
    }

    public void updateExpertInfo(User user, User updatedUser){
        ExpertInfo info = user.getExpertInfo();
        ExpertInfo updatedInfo = updatedUser.getExpertInfo();

        //Description
        info.setDescription(updatedInfo.getDescription());

        //References
        Set<Reference> oldReferences = info.getReferences();
        Set<Reference> newReferences = updatedInfo.getReferences();
        for (Reference reference : oldReferences) {
            if(! newReferences.contains(reference)){
                referenceRepository.delete(reference);
            }
        }
        user.getExpertInfo().setReferences(newReferences);

        //Services
        Set<Service> oldServices = info.getServices();
        Set<Service> newServices = updatedInfo.getServices();

        for (Service oldService : oldServices) {
            if(! newServices.contains(oldService)){
                serviceRepository.delete(oldService);
            }
        }
        user.getExpertInfo().setServices(newServices);
    }



    private void saveUpdatedUser(User user){
        if(user.isExpert()){
            setLocationsToUser(user);
            setProfessionsToUser(user);
        }
        userRepository.save(user);
    }


    private void setLocationsToUser(User user){
        Set<Location> locations = user.getExpertInfo().getLocations();
        for (Location location : locations) {
            Set<ExpertInfo> set = locationRepository.getById(location.getId()).getExpertInfos();
            set.add(user.getExpertInfo());
        }
    }

    private void setProfessionsToUser(User user){
        Set<Profession> professions = user.getExpertInfo().getProfessions();
        for (Profession profession : professions) {
            Set<ExpertInfo> set = professionRepository.getById(profession.getId()).getExpertInfos();
            set.add(user.getExpertInfo());
        }
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
}
