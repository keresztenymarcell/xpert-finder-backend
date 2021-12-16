package com.codecool.mavens.service;

import com.codecool.mavens.model.dto.BookingClientIdExpertId;
import com.codecool.mavens.model.entity.Assignment;
import com.codecool.mavens.model.entity.Booking;
import com.codecool.mavens.model.entity.User;
import com.codecool.mavens.repository.AssignmentRepository;
import com.codecool.mavens.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public void addNewAssignmentWithBooking(BookingClientIdExpertId bookingClientIdExpertId) {
        Booking booking = bookingClientIdExpertId.getBooking();
        Long expertId = bookingClientIdExpertId.getExpertId();
        Long clientId = bookingClientIdExpertId.getClientId();

        User expert = userRepository.getById(expertId);
        User client = userRepository.getById(clientId);

        Assignment assignment = Assignment.builder()
                .startTime(LocalDateTime.now())
                .booking(booking)
                .expert(expert)
                .client(client)
                .build();
        booking.setAssignment(assignment);
        assignmentRepository.save(assignment);
    }
}
