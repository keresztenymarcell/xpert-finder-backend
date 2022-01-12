package com.codecool.mavens.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Transient
    @Singular
    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Profession> professions;

    private String name;


}
