package com.codecool.mavens.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Assignment {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToOne
    private User expert;

    @OneToOne
    private User client;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Recommendation recommendation;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Booking booking;


    @Singular
    @OneToMany(mappedBy = "school", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Message> messages;

}
