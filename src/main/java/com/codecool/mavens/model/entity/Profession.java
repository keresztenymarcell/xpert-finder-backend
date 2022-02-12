package com.codecool.mavens.model.entity;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    private String name;

    @JsonIgnore
    @ManyToMany
    @EqualsAndHashCode.Exclude
    private Set<ExpertInfo> expertInfos;
}
