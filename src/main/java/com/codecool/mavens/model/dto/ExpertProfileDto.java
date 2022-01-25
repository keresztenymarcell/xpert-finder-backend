package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.User;
import lombok.Data;

@Data
public class ExpertProfileDto {

    private ExpertInfoDto expertInfo;
    private PersonalInfoDto personalInfo;

    public ExpertProfileDto(User user) {
        this.expertInfo = new ExpertInfoDto(user.getExpertInfo());
        this.personalInfo = new PersonalInfoDto(user.getPersonalInfo());
    }
}
