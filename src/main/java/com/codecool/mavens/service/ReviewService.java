package com.codecool.mavens.service;


import com.codecool.mavens.model.dto.NewReviewDto;
import com.codecool.mavens.model.entity.ExpertInfo;
import com.codecool.mavens.model.entity.Review;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.repository.ExpertInfoRepository;
import com.codecool.mavens.repository.ReviewRepository;
import com.codecool.mavens.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ReviewService {


    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExpertInfoRepository expertInfoRepository;


    public void addNewReview(NewReviewDto data){
       ExpertInfo expertInfo = expertInfoRepository.findById(data.getExpertId()).orElse(null);
       User reviewer = userRepository.findById(data.getUserId()).orElse(null);

        Review review = Review.builder()
                .expertInfo(expertInfo)
                .reviewer(reviewer)
                .rating(data.getRating())
                .message(data.getMessage())
                .time(LocalDateTime.now())
                .build();

        reviewRepository.saveAndFlush(review);
    }
}
