package com.codecool.mavens.entity;


import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class Assignment {
    private Long id;
    private User expert;
    private User client;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Recommendation recommendation;
    private Booking booking;
    private Set<Message> messages;

}
