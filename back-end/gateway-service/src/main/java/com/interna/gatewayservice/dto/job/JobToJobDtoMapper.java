package com.interna.gatewayservice.dto.job;

import com.interna.gatewayservice.dto.company.CompanyToCompanyDtoMapper;
import com.interna.gatewayservice.model.job.Job;

import java.util.function.Function;

public class JobToJobDtoMapper implements Function<Job, JobDto> {
    @Override
    public JobDto apply(Job job) {
        return new JobDto(
                job.getId(),
                job.getPosition(),
                job.getJobLevel(),
                job.getExperience(),
                job.getJobType(),
                job.getDescription(),
                job.getRequirements(),
                job.getDeadLine(),
                job.isOpen(),
                new CompanyToCompanyDtoMapper().apply(job.getCompany()),
                job.getCreatedDate()
        );
    }
}
