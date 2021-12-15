package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private PersonalInfo personalInfo;
    private ExpertInfo expertInfo;
    private LocalDateTime registrationTime;
    private LocalDateTime lastLoginTime;


}
