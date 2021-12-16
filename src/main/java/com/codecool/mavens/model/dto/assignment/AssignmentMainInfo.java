package com.codecool.mavens.model.dto.assignment;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AssignmentMainInfo {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
