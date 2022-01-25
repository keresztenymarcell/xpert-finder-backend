package com.codecool.mavens.model.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PersonalInfo> personalInfos;

    @JsonIgnore
    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ExpertInfo> expertInfos;

    private String name;
}
