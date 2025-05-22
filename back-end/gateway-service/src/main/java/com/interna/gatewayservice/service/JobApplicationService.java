package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.DuplicationDataException;
import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.job.application.ApplyJobApplicationDto;
import com.interna.gatewayservice.dto.job.application.ApplyJobApplicationDtoToJobApplicationMapper;
import com.interna.gatewayservice.dto.job.application.JobApplicationDto;
import com.interna.gatewayservice.dto.job.application.JobApplicationToJobApplicationDtoMapper;
import com.interna.gatewayservice.model.job.JobApplication;
import com.interna.gatewayservice.repository.JobApplicationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobService jobService;


    public String applyJob(ApplyJobApplicationDto applyJobApplicationDto) {
        new ObjectsValidator<ApplyJobApplicationDto>().apply(applyJobApplicationDto);
        boolean open = jobService.isOpen(applyJobApplicationDto.getJob().getId());
        if (!open) {
            throw new DuplicationDataException("Cannot apply, Job is closed!");
        }
        checkIsApplied(applyJobApplicationDto.getJob().getId(), applyJobApplicationDto.getSeeker().getId());

        JobApplication jobApplication = jobApplicationRepository.save(
                new ApplyJobApplicationDtoToJobApplicationMapper().apply(applyJobApplicationDto)
        );
        return jobApplication.getId();
    }

    public JobApplicationDto getJobApplication(String id) {
        JobApplication jobApplication = jobApplicationRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException("Job is not exist")
        );
        return new JobApplicationToJobApplicationDtoMapper().apply(jobApplication);
    }

    public List<JobApplicationDto> getJobApplicationsForJob(String id) {
        return jobApplicationRepository.findByJobId(id).stream()
                .map(jobApplication -> new JobApplicationToJobApplicationDtoMapper().apply(jobApplication))
                .collect(Collectors.toList());
    }

    public List<JobApplicationDto> getJobApplicationsForSeeker(String id) {
        return jobApplicationRepository.findBySeekerId(id).stream()
                .map(jobApplication -> new JobApplicationToJobApplicationDtoMapper().apply(jobApplication))
                .collect(Collectors.toList());
    }

    public String updateJobApplication(ApplyJobApplicationDto applyJobApplicationDto) {
        new ObjectsValidator<ApplyJobApplicationDto>().apply(applyJobApplicationDto);
        getJobApplication(applyJobApplicationDto.getId());

        JobApplication jobApplication = jobApplicationRepository.save(
                new ApplyJobApplicationDtoToJobApplicationMapper().apply(applyJobApplicationDto)
        );
        return "Job application updated successfully";
    }

    private void checkIsApplied(String jobId, String seekerId) {
        if (jobApplicationRepository.findByJobIdAndSeekerId(jobId, seekerId).isPresent()) {
            throw new DuplicationDataException("Already applied on job application!");
        }
    }

}
