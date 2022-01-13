package com.codecool.mavens.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne()
    private User reviewer;

    @JsonIgnore
    @ManyToOne
    private ExpertInfo expertInfo;

    private int rating;

    private String message;

    private LocalDateTime time;

}