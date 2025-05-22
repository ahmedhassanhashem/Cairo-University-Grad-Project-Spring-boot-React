package com.interna.gatewayservice.dto.job;

import com.interna.gatewayservice.model.job.Job;

import java.time.LocalDateTime;
import java.util.function.Function;

public class CompanyJobDtoToJobMapper implements Function<CompanyJobDto, Job> {
    @Override
    public Job apply(CompanyJobDto companyJobDto) {
        return new Job(
                companyJobDto.getId(),
                companyJobDto.getPosition(),
                companyJobDto.getJobLevel(),
                companyJobDto.getExperience(),
                companyJobDto.getJobType(),
                companyJobDto.getDescription(),
                companyJobDto.getRequirements(),
                companyJobDto.getDeadLine(),
                null,
                LocalDateTime.now(),
                companyJobDto.isOpen(),
                null
        );
    }
}
