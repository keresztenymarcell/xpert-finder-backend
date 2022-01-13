package com.codecool.mavens.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExpertInfo {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "expertInfo")
    private User user;

    private Double rating;

    private int jobCount;

    private String description;

    @Singular("reference")
    @OneToMany(mappedBy = "expertInfo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Reference> reference;

    @Singular
    @OneToMany(mappedBy = "expertInfo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Location> locations;

    @Singular
    @OneToMany(mappedBy = "expertInfo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Profession> professions;

    @Singular
    @OneToMany(mappedBy = "expertInfo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Review> reviews;

    @Singular
    @OneToMany(mappedBy = "expertInfo", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Service> services;
}
