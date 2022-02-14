package com.codecool.mavens.repository;

import com.codecool.mavens.model.entity.ExpertInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertInfoRepository extends JpaRepository<ExpertInfo, Long> {

}
