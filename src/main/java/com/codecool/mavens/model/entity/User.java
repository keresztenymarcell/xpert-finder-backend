package com.codecool.mavens.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @EqualsAndHashCode.Exclude
    private PersonalInfo personalInfo;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})


    @EqualsAndHashCode.Exclude
    private ExpertInfo expertInfo;

    private LocalDateTime registrationTime;

    private LocalDateTime lastLoginTime;

    @Singular
    @OneToMany(mappedBy = "reviewer")
    @EqualsAndHashCode.Exclude
    private Set<Review> reviews;

/*    @OneToOne
    private Assignment expert;

    @OneToOne
    private Assignment client;*/


    public boolean isExpert(){
        return this.getExpertInfo() != null;
    }
}
