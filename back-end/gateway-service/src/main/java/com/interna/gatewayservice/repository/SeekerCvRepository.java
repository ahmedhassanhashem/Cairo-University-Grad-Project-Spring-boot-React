package com.interna.gatewayservice.repository;


import com.interna.gatewayservice.model.cv.SeekerCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeekerCvRepository extends JpaRepository<SeekerCv, String> {
}
