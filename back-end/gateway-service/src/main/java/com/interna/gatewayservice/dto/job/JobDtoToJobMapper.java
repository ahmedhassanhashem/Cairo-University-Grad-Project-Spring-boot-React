package com.interna.gatewayservice.dto.job;

import com.interna.gatewayservice.model.company.Company;
import com.interna.gatewayservice.model.job.Job;

import java.time.LocalDateTime;
import java.util.function.Function;

public class JobDtoToJobMapper implements Function<JobDto, Job> {
    @Override
    public Job apply(JobDto jobDto) {
        Company company = new Company();
        company.setId(jobDto.getCompany().getId());
        return new Job(
                jobDto.getId(),
                jobDto.getPosition(),
                jobDto.getJobLevel(),
                jobDto.getExperience(),
                jobDto.getJobType(),
                jobDto.getDescription(),
                jobDto.getRequirements(),
                jobDto.getDeadLine(),
                company,
                LocalDateTime.now(),
                jobDto.isOpen(),
                null
        );
    }
}
