package com.interna.gatewayservice.repository;

import com.interna.gatewayservice.model.cv.EducationalQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationalQualificationRepository extends JpaRepository<EducationalQualification, Long> {

    void deleteAllByCvId(String id);

}
