package com.codecool.mavens.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private Sender sender;

    private LocalDateTime sendTime;

    private String content;

    @ManyToOne
    private Assignment assignment;
}
