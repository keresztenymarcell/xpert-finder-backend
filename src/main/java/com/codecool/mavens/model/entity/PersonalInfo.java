package com.codecool.mavens.model.entity;

import com.codecool.mavens.model.types.Role;
import com.codecool.mavens.model.types.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "personalInfo") // to User
    @EqualsAndHashCode.Exclude
    private User user;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Location location;

    private String username;

    private String name;

    private String password;

    private String email;

    private String phoneNumber;

    private Status status;

    private String profilePicture;

}
