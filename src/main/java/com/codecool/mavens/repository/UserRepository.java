package com.codecool.mavens.repository;

import com.codecool.mavens.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
