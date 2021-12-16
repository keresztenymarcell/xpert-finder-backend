package com.codecool.mavens.model.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginData {

    private String username;
    private String password;


}
