package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Location {


    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "location")
    private PersonalInfo personalInfo;

/*    @ManyToOne
    private ExpertInfo expertInfo;*/

    private String name;


}
