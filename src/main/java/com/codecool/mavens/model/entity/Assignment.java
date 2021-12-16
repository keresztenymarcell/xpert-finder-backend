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
public class Assignment {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User expert;

    @OneToOne
    private User client;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    //
//    private Recommendation recommendation;
//
    @OneToOne(cascade = CascadeType.PERSIST)
    private Booking booking;
//
//    private Set<Message> messages;

}
