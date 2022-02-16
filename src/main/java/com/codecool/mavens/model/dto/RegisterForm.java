package com.codecool.mavens.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {

    private String email;
    private String username;
    private String name;
    private String emailAddress;
    private String password;
    private String confirmPassword;
    private Long locationId;
    private String phoneNumber;

}
