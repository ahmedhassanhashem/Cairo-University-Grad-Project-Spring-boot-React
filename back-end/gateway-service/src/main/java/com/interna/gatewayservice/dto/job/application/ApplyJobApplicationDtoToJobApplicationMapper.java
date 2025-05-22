package com.interna.gatewayservice.dto.job.application;

import com.interna.gatewayservice.dto.job.CompanyJobDtoToJobMapper;
import com.interna.gatewayservice.dto.seeker.SeekerJobDtoToSeekerMapper;
import com.interna.gatewayservice.model.job.JobApplication;

import java.time.LocalDateTime;
import java.util.function.Function;

public class ApplyJobApplicationDtoToJobApplicationMapper implements Function<ApplyJobApplicationDto, JobApplication> {
    @Override
    public JobApplication apply(ApplyJobApplicationDto applyJobApplicationDto) {
        return new JobApplication(
                applyJobApplicationDto.getId(),
                new CompanyJobDtoToJobMapper().apply(applyJobApplicationDto.getJob()),
                new SeekerJobDtoToSeekerMapper().apply(applyJobApplicationDto.getSeeker()),
                applyJobApplicationDto.getStatus(),
                applyJobApplicationDto.getFeedback(),
                LocalDateTime.now()
        );
    }
}
