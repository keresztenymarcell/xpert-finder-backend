package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PersonalInfo personalInfo;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ExpertInfo expertInfo;

    private LocalDateTime registrationTime;

    private LocalDateTime lastLoginTime;

/*    @OneToOne
    private Assignment expert;

    @OneToOne
    private Assignment client;*/


}
