package com.codecool.mavens.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Assignment {

    @Id
    @GeneratedValue
    private Long id;

/*    @OneToOne
    private User expert;

    @OneToOne
    private User client;*/

    private LocalDateTime startTime;

    private LocalDateTime endTime;

//
//    private Recommendation recommendation;
//
//    private Booking booking;
//
//    private Set<Message> messages;

}
