package com.interna.gatewayservice.repository;

import com.interna.gatewayservice.model.cv.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {

    void deleteAllByCvId(String id);

}
