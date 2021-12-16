package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.assignment.BookingClientIdExpertIdTitle;
import com.codecool.mavens.model.dto.assignment.RecommendationClosingMessageAssignmentId;
import com.codecool.mavens.model.entity.*;
import com.codecool.mavens.repository.AssignmentRepository;
import com.codecool.mavens.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private UserRepository userRepository;



    public Assignment getAssignmentById(Long id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id) ;
        return assignment.orElse(null);
    }

    public void addNewAssignmentWithBooking(BookingClientIdExpertIdTitle bookingClientIdExpertIdTitle) {
        Booking booking = bookingClientIdExpertIdTitle.getBooking();
        Long expertId = bookingClientIdExpertIdTitle.getExpertId();
        Long clientId = bookingClientIdExpertIdTitle.getClientId();
        String title = bookingClientIdExpertIdTitle.getTitle();

        User expert = userRepository.getById(expertId);
        User client = userRepository.getById(clientId);

        Assignment assignment = Assignment.builder()
                .startTime(LocalDateTime.now())
                .booking(booking)
                .expert(expert)
                .client(client)
                .title(title)
                .build();
        booking.setAssignment(assignment);
        assignmentRepository.save(assignment);
    }

    public void closeAssignmentWithRecommendation(RecommendationClosingMessageAssignmentId recommendationClosingMessageAssignmentId) {
        Long assignmentId = recommendationClosingMessageAssignmentId.getAssignmentId();
        Message closingMessage = recommendationClosingMessageAssignmentId.getClosingMessage();
        Recommendation recommendation = recommendationClosingMessageAssignmentId.getRecommendation();

        Assignment assignment = assignmentRepository.getById(assignmentId);

        assignment.setRecommendation(recommendation);

        Set<Message> messages = assignment.getMessages();
        messages.add(closingMessage);
        assignment.setMessages(messages);

        closingMessage.setAssignment(assignment);

        assignmentRepository.save(assignment);
    }

    // Add Review to Assignment and finish it

    // Get All Assignment
}
