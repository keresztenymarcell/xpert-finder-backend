package com.codecool.mavens.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reference {
    private Long id;
    private String description;
    private String imagePath;
}
