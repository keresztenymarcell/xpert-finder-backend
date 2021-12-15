package com.codecool.mavens.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

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
