package com.interna.gatewayservice.repository;


import com.interna.gatewayservice.model.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

    List<Job> findByCompanyId(String id);

    List<Job> findByPositionContainingAndOpenIsTrue(String position);

    List<Job> findByPositionContainingAndJobTypeAndOpenIsTrue(String position, String jobType);

    List<Job> findByPositionContainingAndCompanyCityIdAndOpenIsTrue(String position, long cityId);

    List<Job> findByPositionContainingAndCompanyCityIdAndJobTypeAndOpenIsTrue(String position, long cityId, String jobType);

}
