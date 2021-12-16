package com.codecool.mavens.repository;

import com.codecool.mavens.model.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // Hopefully it works ^^
    @Query("select a from Assignment a where a.client.id = :id")
    List<Assignment> getAllByClientEquals(Long id);
}
