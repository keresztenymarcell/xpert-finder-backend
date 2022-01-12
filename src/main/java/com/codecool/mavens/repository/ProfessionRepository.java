package com.codecool.mavens.repository;

import com.codecool.mavens.model.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
