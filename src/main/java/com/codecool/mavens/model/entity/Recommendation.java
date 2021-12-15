package com.codecool.mavens.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recommendation {
    private Long id;
    private Double rating;
    private String review;
}
