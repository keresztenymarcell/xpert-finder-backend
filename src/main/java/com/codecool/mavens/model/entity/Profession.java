package com.codecool.mavens.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profession {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    @ManyToOne
    private Category category;

    private String name;
}
