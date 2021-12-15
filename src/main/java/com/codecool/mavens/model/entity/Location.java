package com.codecool.mavens.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
    private Long id;
    private String name;
}
