package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recommendation {

    @Id
    @GeneratedValue
    private Long id;

    private Double rating;

    private String review;

    @OneToOne(mappedBy = "recommendation")
    private Assignment assignment;
}
