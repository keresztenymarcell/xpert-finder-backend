package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Reference {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ExpertInfo expertInfo;

    private String description;

    private String imagePath;
}
