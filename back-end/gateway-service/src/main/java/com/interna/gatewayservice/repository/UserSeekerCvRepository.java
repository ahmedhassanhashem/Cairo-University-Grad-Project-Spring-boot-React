package com.interna.gatewayservice.repository;


import com.interna.gatewayservice.model.cv.UserSeekerCv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSeekerCvRepository extends JpaRepository<UserSeekerCv, String> {
}
