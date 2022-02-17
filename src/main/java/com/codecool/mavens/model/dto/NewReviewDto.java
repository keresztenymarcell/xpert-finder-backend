package com.codecool.mavens.model.dto;


import lombok.Data;

@Data
public class NewReviewDto {

    private final Long expertId;
    private final Long userId;
    private final String message;
    private final int rating;

    public NewReviewDto(Long expertId, Long userId, String message, int rating) {
        this.expertId = expertId;
        this.userId = userId;
        this.message = message;
        this.rating = rating;
    }
}
