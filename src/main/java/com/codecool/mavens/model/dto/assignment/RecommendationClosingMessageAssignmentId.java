package com.codecool.mavens.model.dto.assignment;

import com.codecool.mavens.model.entity.Message;
import com.codecool.mavens.model.entity.Recommendation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecommendationClosingMessageAssignmentId {
    private Long assignmentId;
    private Message closingMessage;
    private Recommendation recommendation;
}
