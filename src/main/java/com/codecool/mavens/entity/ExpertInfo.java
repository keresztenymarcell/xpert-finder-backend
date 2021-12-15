package com.codecool.mavens.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ExpertInfo {
    private Long id;
    private Double rating;
    private int jobCount;
    private Set<Reference> reference;
}
