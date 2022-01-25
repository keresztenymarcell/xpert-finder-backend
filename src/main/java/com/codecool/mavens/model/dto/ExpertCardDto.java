package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.User;
import lombok.Data;

import java.util.Set;

@Data
public class ExpertCardDto {

    private Long id;

    private String profilePicture;

    private String name;

    private ExpertInfoDto expertInfo;

    public ExpertCardDto(User user) {
        this.id = user.getId();
        this.profilePicture = user.getPersonalInfo().getProfilePicture();
        this.name = user.getPersonalInfo().getName();
        this.expertInfo = new ExpertInfoDto(user.getExpertInfo());
    }
}
