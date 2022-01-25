package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.PersonalInfo;
import com.codecool.mavens.model.types.Role;
import com.codecool.mavens.model.types.Status;
import lombok.Data;

@Data
public class ReviewerDto {
    private String username;
    private String profilePicture;
    private Status status;
    private Role role;

    public ReviewerDto(PersonalInfo reviewerPersonalInfo) {
        this.username = reviewerPersonalInfo.getUsername();
        this.profilePicture = reviewerPersonalInfo.getProfilePicture();
        this.status = reviewerPersonalInfo.getStatus();
        this.role = reviewerPersonalInfo.getRole();
    }
}
