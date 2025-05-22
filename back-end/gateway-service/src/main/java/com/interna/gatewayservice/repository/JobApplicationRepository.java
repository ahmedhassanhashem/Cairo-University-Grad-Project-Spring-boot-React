package com.interna.gatewayservice.repository;

import com.interna.gatewayservice.model.job.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, String> {

    Optional<JobApplication> findByJobIdAndSeekerId(String JobId, String seekerId);
    List<JobApplication> findByJobId(String id);

    List<JobApplication> findBySeekerId(String id);

}
