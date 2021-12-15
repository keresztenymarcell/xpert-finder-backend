package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.ExpertInfo;
import com.codecool.mavens.model.entity.PersonalInfo;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ExpertPersonalInfo {

    private PersonalInfo personalInfo;
    private ExpertInfo expertInfo;
}
