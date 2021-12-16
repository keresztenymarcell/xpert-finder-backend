package com.codecool.mavens.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "personalInfo")
    @EqualsAndHashCode.Exclude
    private User user;

    private String username;
    private String name;
    private String password;
    private String email;


    @OneToOne(cascade = CascadeType.PERSIST)
    private Location location;

    private String phoneNumber;
    private Status status;
    private Role role;
}
