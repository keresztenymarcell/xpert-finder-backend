package com.codecool.mavens.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {


    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "location")
    private PersonalInfo personalInfo;

    @ManyToMany
    @JsonIgnore
    private Set<ExpertInfo> expertInfos;

    private String name;






}
