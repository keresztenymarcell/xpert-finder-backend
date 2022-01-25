package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.PersonalInfo;
import lombok.Data;

@Data
public class PersonalInfoDto {

    private Long id;

    private LocationDto location;

    private String username;

    private String name;

    private String email;

    private String phoneNumber;

//    private Status status;
//
//    private Role role;

    private String profilePicture;

    public PersonalInfoDto(PersonalInfo personalInfo) {
        this.id = personalInfo.getId();
        this.location = new LocationDto(personalInfo.getLocation());
        this.username = personalInfo.getUsername();
        this.name = personalInfo.getName();
        this.email = personalInfo.getEmail();
        this.phoneNumber = personalInfo.getPhoneNumber();
        this.profilePicture = personalInfo.getProfilePicture();
    }
}
