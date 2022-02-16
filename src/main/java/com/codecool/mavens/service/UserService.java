package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.*;
import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.model.types.Status;
import com.codecool.mavens.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserService  implements UserDetailsService {

    private final UserRepository userRepository;
    private final PersonalInfoRepository personalInfoRepository;
    private final ExpertInfoRepository expertInfoRepository;
    private final LocationRepository locationRepository;
    private final ProfessionRepository professionRepository;
    private final ReferenceRepository referenceRepository;
    private final ServiceRepository serviceRepository;
    private final ReviewRepository reviewRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;


    public List<ExpertCardDto> getAllExpertCards() {
        return userRepository.findByExpertInfoNotNull().stream().map(ExpertCardDto::new).collect(Collectors.toList());
    }


    public User getUserByID(Long id) {
        User user = userRepository.getById(id);
        user.getPersonalInfo().setPassword("");
        return user;
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        user.getPersonalInfo().setPassword("");
        return user;
    }


    public ExpertProfileDto getExpertInfo(Long id) {
        return new ExpertProfileDto(userRepository.getById(id));
    }


    public ExpertCardDto getExpertCard(Long id) {
        return new ExpertCardDto(userRepository.getById(id));
    }


    public boolean authenticateUser(UserLoginData data) {
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


    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    public boolean registerUser(RegisterForm form){

        //Check if username is already used
        if(userRepository.findByUsername(form.getUsername()) != null){
            return false;
        } else{

            PersonalInfo personalInfo = PersonalInfo.builder()
                            .username(form.getUsername())
                            .name(form.getName())
                            .email(form.getEmail())
                            .phoneNumber(form.getPhoneNumber())
                            .password(passwordEncoder.encode(form.getPassword()))
                            .location(locationRepository.getById(form.getLocationId()))
                            .profilePicture(null)
                            .build();

            personalInfoRepository.saveAndFlush(personalInfo);

            User newUser = User.builder()
                    .personalInfo(personalInfo)
                    .registrationTime(LocalDateTime.now())
                    .roles(List.of(roleRepository.findByName("ROLE_USER")))
                    .build();
            userRepository.saveAndFlush(newUser);

            return true;
        }
    }

    public void addNewUser(User user) {
        String password = user.getPersonalInfo().getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.getPersonalInfo().setPassword(encodedPassword);
        user.getPersonalInfo().setStatus(Status.ACTIVE);
        PersonalInfo personalInfo = personalInfoRepository.saveAndFlush(user.getPersonalInfo());
        Location personalLocation = locationRepository.getById(user.getPersonalInfo().getLocation().getId());

        personalInfo.setLocation(personalLocation);
        personalLocation.getPersonalInfos().add(personalInfo);


        user.setRoles(List.of(roleRepository.findByName("ROLE_USER")));

        ExpertInfo expertInfoPlaceholder = null;
        if (user.getExpertInfo() != null) {
            user.setRoles(List.of(roleRepository.findByName("ROLE_USER"), roleRepository.findByName("ROLE_EXPERT")));

            ExpertInfo expertInfo = expertInfoRepository.saveAndFlush(user.getExpertInfo());

            Set<Location> workLocations = getWorkLocations(user.getExpertInfo().getLocations());
            workLocations.forEach(location -> location.getExpertInfos().add(expertInfo));

            Set<Profession> professions = getProfessions(user.getExpertInfo().getProfessions());
            professions.forEach(profession -> profession.getExpertInfos().add(expertInfo));

            if (expertInfo.getServices() != null) {
                Set<Service> services = expertInfo.getServices();
                services.forEach(service -> service.setExpertInfo(expertInfo));
                serviceRepository.saveAllAndFlush(services);
            }

            if (expertInfo.getReferences() != null) {
                Set<Reference> references = expertInfo.getReferences();
                references.forEach(reference -> reference.setExpertInfo(expertInfo));
                referenceRepository.saveAllAndFlush(references);
            }
            expertInfoPlaceholder = expertInfo;
        }
        user.setPersonalInfo(personalInfo);
        user.setExpertInfo(expertInfoPlaceholder);
        user.setRegistrationTime(LocalDateTime.now());
        userRepository.saveAndFlush(user);
    }


    public void updateUser(User user) {
        String password = personalInfoRepository.getById(user.getPersonalInfo().getId()).getPassword();
        user.getPersonalInfo().setPassword(password);
        personalInfoRepository.saveAndFlush(user.getPersonalInfo());

        ExpertInfo expertInfo = user.getExpertInfo();

        if (expertInfo != null) {
            ExpertInfo oldExpertInfo = expertInfoRepository.getById(user.getExpertInfo().getId());
            updateProfessions(expertInfo, oldExpertInfo);
            updateLocations(expertInfo, oldExpertInfo);
            updateServices(expertInfo, oldExpertInfo);
            updateReferences(expertInfo, oldExpertInfo);

            expertInfoRepository.saveAndFlush(expertInfo);
        }
        userRepository.saveAndFlush(user);
    }


    private void updateProfessions(ExpertInfo expertInfo, ExpertInfo oldExpertInfo) {

        Set<Profession> oldProfessions = getProfessions(oldExpertInfo.getProfessions());
        Set<Profession> newProfessions = getProfessions(expertInfo.getProfessions());

        if (!oldProfessions.equals(newProfessions)) {
            Set<Profession> professionsToRemove = oldProfessions.stream().filter(profession -> !newProfessions.contains(profession)).collect(Collectors.toSet());
            Set<Profession> professionsToAdd = newProfessions.stream().filter(profession -> !oldProfessions.contains(profession)).collect(Collectors.toSet());

            for (Profession profession : professionsToRemove) {
                Set<ExpertInfo> expertInfos = new HashSet<>(profession.getExpertInfos());
                expertInfos.remove(oldExpertInfo);
                profession.setExpertInfos(expertInfos);
                professionRepository.saveAndFlush(profession);
            }
            professionsToAdd.forEach(location -> location.getExpertInfos().add(expertInfo));
            professionRepository.saveAllAndFlush(professionsToAdd);
        }
    }


    private void updateLocations(ExpertInfo expertInfo, ExpertInfo oldExpertInfo) {

        Set<Location> oldLocations = getWorkLocations(oldExpertInfo.getLocations());
        Set<Location> newLocations = getWorkLocations(expertInfo.getLocations());

        if (!oldLocations.equals(newLocations)) {
            Set<Location> locationsToRemove = oldLocations.stream().filter(location -> !newLocations.contains(location)).collect(Collectors.toSet());
            Set<Location> locationsToAdd = newLocations.stream().filter(location -> !oldLocations.contains(location)).collect(Collectors.toSet());

            for (Location location : locationsToRemove) {
                Set<ExpertInfo> expertInfos = new HashSet<>(location.getExpertInfos());
                expertInfos.remove(oldExpertInfo);
                location.setExpertInfos(expertInfos);
                locationRepository.saveAndFlush(location);
            }
            locationsToAdd.forEach(location -> location.getExpertInfos().add(expertInfo));
            locationRepository.saveAllAndFlush(locationsToAdd);
        }
    }


    private void updateServices(ExpertInfo expertInfo, ExpertInfo oldExpertInfo) {
        Set<Service> oldServices = oldExpertInfo.getServices();
        Set<Service> newServices = expertInfo.getServices();

        if (!oldServices.equals(newServices)) {
            Set<Long> newServiceIds = newServices.stream().map(Service::getId).collect(Collectors.toSet());

            Set<Service> servicesToRemove = oldServices.stream().filter(service -> !newServiceIds.contains(service.getId())).collect(Collectors.toSet());
            serviceRepository.deleteAll(servicesToRemove);

            newServices.forEach(service -> service.setExpertInfo(expertInfo));
            serviceRepository.saveAllAndFlush(newServices);
        }
    }


    private void updateReferences(ExpertInfo expertInfo, ExpertInfo oldExpertInfo) {
        Set<Reference> oldReferences = oldExpertInfo.getReferences();
        Set<Reference> newReferences = expertInfo.getReferences();

        if(!oldReferences.equals(newReferences)) {
            Set<Long> newReferenceIds = newReferences.stream().map(Reference::getId).collect(Collectors.toSet());

            Set<Reference> referencesToRemove = oldReferences.stream().filter(reference -> !newReferenceIds.contains(reference.getId())).collect(Collectors.toSet());
            referenceRepository.deleteAll(referencesToRemove);

            newReferences.forEach(reference -> reference.setExpertInfo(expertInfo));
            referenceRepository.saveAllAndFlush(newReferences);
        }
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found in the database");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(
                user.getPersonalInfo().getUsername(),
                user.getPersonalInfo().getPassword(),
                authorities);

    }
}
