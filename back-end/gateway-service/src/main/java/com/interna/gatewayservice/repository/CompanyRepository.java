package com.interna.gatewayservice.repository;


import com.interna.gatewayservice.model.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    Optional<Company> findByEmail(String email);
    Optional<Company> findByUserId(String userId);

}
