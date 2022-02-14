package com.codecool.mavens.repository;

import com.codecool.mavens.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByExpertInfoNotNull();

    @Query("SELECT u FROM User u WHERE u.personalInfo.username = :username")
    User findByUsername(@Param("username") String username);

    // TODO: select all from User where expert_info.professions contains professionId AND expert_info.locations contains locationId
    /*@Query("")
    List<User> findAllByLocationId(@Param("locationId") Long locationId, @Param("professionId") Long professionId);*/
}
