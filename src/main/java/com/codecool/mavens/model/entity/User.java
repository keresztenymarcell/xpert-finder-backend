package com.codecool.mavens.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.PERSIST)
    private PersonalInfo personalInfo;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.PERSIST)
    @EqualsAndHashCode.Exclude
    private ExpertInfo expertInfo;

    private LocalDateTime registrationTime;

    private LocalDateTime lastLoginTime;

/*    @OneToOne
    private Assignment expert;

    @OneToOne
    private Assignment client;*/


}
