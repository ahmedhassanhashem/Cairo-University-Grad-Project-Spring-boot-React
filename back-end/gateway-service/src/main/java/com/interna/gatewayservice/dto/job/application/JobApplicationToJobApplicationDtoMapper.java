package com.interna.gatewayservice.dto.job.application;

import com.interna.gatewayservice.dto.job.JobToJobDtoMapper;
import com.interna.gatewayservice.dto.seeker.SeekerToSeekerDtoMapper;
import com.interna.gatewayservice.model.job.JobApplication;

import java.util.function.Function;

public class JobApplicationToJobApplicationDtoMapper implements Function<JobApplication, JobApplicationDto> {
    @Override
    public JobApplicationDto apply(JobApplication jobApplication) {
        return new JobApplicationDto(
                jobApplication.getId(),
                jobApplication.getStatus(),
                new JobToJobDtoMapper().apply(jobApplication.getJob()),
                new SeekerToSeekerDtoMapper().apply(jobApplication.getSeeker()),
                jobApplication.getFeedback(),
                jobApplication.getCreatedDate()
        );
    }
}
