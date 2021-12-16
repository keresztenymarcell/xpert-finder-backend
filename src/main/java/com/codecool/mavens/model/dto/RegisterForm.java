package com.codecool.mavens.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterForm {

    private String email;
    private String username;
    private String name;
    private String emailAddress;
    private String password;
    private String confirmPassword;
    private Long locationID;
    private String phoneNumber;


}
