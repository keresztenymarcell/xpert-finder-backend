package com.codecool.mavens.model.entity;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class Message {
    private Long id;
    private User from;
    private User to;
    private LocalDateTime sendTime;
    private String content;
}
