package com.interna.gatewayservice.repository;


import com.interna.gatewayservice.model.seeker.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeekerRepository extends JpaRepository<Seeker, String> {
    Optional<Seeker> findByEmail(String email);

    Optional<Seeker> findByUserId(String userId);
}
