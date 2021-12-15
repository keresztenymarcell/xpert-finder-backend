package com.codecool.mavens.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Profession {
    private Long id;
    private String name;
}
