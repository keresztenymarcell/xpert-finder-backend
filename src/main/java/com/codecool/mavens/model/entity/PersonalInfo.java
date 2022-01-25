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
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "personalInfo") // to User
    @EqualsAndHashCode.Exclude
    private User user;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Location location;

    private String username;

    private String name;

    @JsonIgnore
    private String password;

    private String email;

    private String phoneNumber;

    private Status status;

    private Role role;

    private String profilePicture;

}
