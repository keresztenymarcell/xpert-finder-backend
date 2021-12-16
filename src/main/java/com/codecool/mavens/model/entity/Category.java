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
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "category")
    private Profession profession;

    private String name;


}
