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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profession {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category category;

    private String name;

    @ManyToMany
    @JsonIgnore
    private Set<ExpertInfo> expertInfos;
}
