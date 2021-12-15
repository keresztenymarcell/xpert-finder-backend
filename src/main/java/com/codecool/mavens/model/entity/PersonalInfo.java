package com.codecool.mavens.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalInfo {
    private Long id;
    private String username;
    private String name;
    private String password;
    private String email;
    private Location location;
    private String phoneNumber;
    private Status status;
    private Role role;
}
