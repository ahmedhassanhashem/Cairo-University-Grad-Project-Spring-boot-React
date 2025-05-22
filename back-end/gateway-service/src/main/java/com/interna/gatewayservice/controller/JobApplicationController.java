package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.job.application.ApplyJobApplicationDto;
import com.interna.gatewayservice.dto.job.application.JobApplicationDto;
import com.interna.gatewayservice.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/job/application")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;


    @PostMapping
    public ResponseEntity<ApiResponse<String>> applyJob(@RequestBody ApplyJobApplicationDto applyJobApplicationDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(jobApplicationService.applyJob(applyJobApplicationDto))
                                .build()
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<JobApplicationDto>> getJobApplication(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<JobApplicationDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(jobApplicationService.getJobApplication(id))
                        .build()
        );
    }

    @GetMapping("job/{id}")
    public ResponseEntity<ApiResponse<List<JobApplicationDto>>> getJobApplicationsForJob(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<List<JobApplicationDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(jobApplicationService.getJobApplicationsForJob(id))
                        .build()
        );
    }

    @GetMapping("seeker/{id}")
    public ResponseEntity<ApiResponse<List<JobApplicationDto>>> getJobApplicationsForSeeker(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<List<JobApplicationDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(jobApplicationService.getJobApplicationsForSeeker(id))
                        .build()
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<String>> updateJob(@RequestBody ApplyJobApplicationDto applyJobApplicationDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.ACCEPTED.value())
                                .status(HttpStatus.ACCEPTED.name())
                                .timestamp(LocalDateTime.now())
                                .data(jobApplicationService.updateJobApplication(applyJobApplicationDto))
                                .build()
                );
    }

}
