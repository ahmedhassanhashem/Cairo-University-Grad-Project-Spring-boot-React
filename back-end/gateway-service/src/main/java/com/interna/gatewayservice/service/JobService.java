package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.job.*;
import com.interna.gatewayservice.model.job.Job;
import com.interna.gatewayservice.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;


    public String addJob(JobDto jobDto) {
        new ObjectsValidator<JobDto>().apply(jobDto);
        Job job = jobRepository.save(
                new JobDtoToJobMapper().apply(jobDto)
        );
        return job.getId();
    }

    public JobDto getJob(String id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException(String.format("job id '%s' is not found", id))
        );
        return new JobToJobDtoMapper().apply(job);
    }

    public String updateJob(JobDto jobDto) {
        new ObjectsValidator<JobDto>().apply(jobDto);
        jobRepository.save(
                new JobDtoToJobMapper().apply(jobDto)
        );
        return "job updated successfully";
    }

    public List<CompanyJobDto> getCompanyJobs(String id) {
        return jobRepository.findByCompanyId(id).stream()
                .map(job -> new JobToCompanyJobsDtoMapper().apply(job))
                .collect(Collectors.toList());
    }

    public List<JobDto> search(JobSearchDto jobSearchDto) {
        new ObjectsValidator<JobSearchDto>().apply(jobSearchDto);
        if (jobSearchDto.getCityId() == 0 && jobSearchDto.getJobType() == null) {
            return jobRepository.findByPositionContainingAndOpenIsTrue(jobSearchDto.getPosition()).stream()
                    .map(job -> new JobToJobDtoMapper().apply(job))
                    .collect(Collectors.toList());
        } else if (jobSearchDto.getCityId() != 0 && jobSearchDto.getJobType() == null) {
            return jobRepository.findByPositionContainingAndCompanyCityIdAndOpenIsTrue(jobSearchDto.getPosition(), jobSearchDto.getCityId()).stream()
                    .map(job -> new JobToJobDtoMapper().apply(job))
                    .collect(Collectors.toList());
        } else if (jobSearchDto.getCityId() == 0 && jobSearchDto.getJobType() != null) {
            return jobRepository.findByPositionContainingAndJobTypeAndOpenIsTrue(jobSearchDto.getPosition(), jobSearchDto.getJobType()).stream()
                    .map(job -> new JobToJobDtoMapper().apply(job))
                    .collect(Collectors.toList());
        } else {
            return jobRepository.findByPositionContainingAndCompanyCityIdAndJobTypeAndOpenIsTrue(jobSearchDto.getPosition(), jobSearchDto.getCityId(), jobSearchDto.getJobType()).stream()
                    .map(job -> new JobToJobDtoMapper().apply(job))
                    .collect(Collectors.toList());
        }
    }

    public boolean isOpen(String id) {
        return getJob(id).isOpen();
    }

}
