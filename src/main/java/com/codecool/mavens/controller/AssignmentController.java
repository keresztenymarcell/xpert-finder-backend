package com.codecool.mavens.controller;

import com.codecool.mavens.model.dto.assignment.AssignmentMainInfo;
import com.codecool.mavens.model.dto.assignment.BookingClientIdExpertIdTitle;
import com.codecool.mavens.model.dto.assignment.RecommendationClosingMessageAssignmentId;
import com.codecool.mavens.model.entity.Assignment;
import com.codecool.mavens.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/{id}")
    public Assignment getAssignmentById(@PathVariable("id") Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PostMapping("/booking/add-new")
    public String addNewBooking(@RequestBody BookingClientIdExpertIdTitle bookingClientIdExpertIdTitle) {
        // NEED: Booking, ClientId, ExpertId
        assignmentService.addNewAssignmentWithBooking(bookingClientIdExpertIdTitle);
        return "added";
    }

    @PostMapping("/recommendation/add-new")
    public String addNewRecommendation(@RequestBody RecommendationClosingMessageAssignmentId recommendationClosingMessageAssignmentId) {
        assignmentService.closeAssignmentWithRecommendation(recommendationClosingMessageAssignmentId);
        return "closed";
    }

    @GetMapping("/all-main-info/{id}")
    public List<AssignmentMainInfo> getAllAssignmentMainInfo(@PathVariable("id") Long id) {
        return assignmentService.getAllAssignmentMainInfo(id);
    }



}
