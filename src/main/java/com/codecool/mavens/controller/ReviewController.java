package com.codecool.mavens.controller;


import com.codecool.mavens.model.dto.NewReviewDto;
import com.codecool.mavens.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/new")
    public void addNewReview(@RequestBody NewReviewDto data){
        reviewService.addNewReview(data);
    }

}
