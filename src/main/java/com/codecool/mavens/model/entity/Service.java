package com.codecool.mavens.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String price;

    @ManyToOne
    private ExpertInfo expertInfo;
}