package com.codecool.mavens.repository;

import com.codecool.mavens.model.entity.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {

    PersonalInfo findByUsername(String username);
}
