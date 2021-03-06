package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.Review;
import com.codecool.mavens.util.DateFormatter;
import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private ReviewerDto reviewer;
    private int rating;
    private String message;
    private String time;

    public ReviewDto(Review review) {
        this.id = review.getId();
        this.reviewer = new ReviewerDto(review.getReviewer().getPersonalInfo());
        this.rating = review.getRating();
        this.message = review.getMessage();
        this.time = DateFormatter.formatLocalDateTime(review.getTime());
    }
}
