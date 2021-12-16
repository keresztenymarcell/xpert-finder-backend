package com.codecool.mavens.controller;

import com.codecool.mavens.model.dto.BookingClientIdExpertId;
import com.codecool.mavens.model.entity.Assignment;
import com.codecool.mavens.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String addNewBooking(@RequestBody BookingClientIdExpertId bookingClientIdExpertId) {
        // NEED: Booking, ClientId, ExpertId
        assignmentService.addNewAssignmentWithBooking(bookingClientIdExpertId);
        return "added";
    }



}
