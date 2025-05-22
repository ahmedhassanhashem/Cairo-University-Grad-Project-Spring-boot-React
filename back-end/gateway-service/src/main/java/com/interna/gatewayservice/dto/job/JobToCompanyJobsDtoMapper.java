package com.interna.gatewayservice.dto.job;

import com.interna.gatewayservice.model.job.Job;

import java.util.function.Function;

public class JobToCompanyJobsDtoMapper implements Function<Job, CompanyJobDto> {
    @Override
    public CompanyJobDto apply(Job job) {
        return new CompanyJobDto(
                job.getId(),
                job.getPosition(),
                job.getJobLevel(),
                job.getExperience(),
                job.getJobType(),
                job.getDescription(),
                job.getRequirements(),
                job.isOpen(),
                job.getDeadLine(),
                job.getCreatedDate()
        );
    }
}
