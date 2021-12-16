package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    //private User from;

    //private User to;

    private LocalDateTime sendTime;

    private String content;
}
