package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.job.CompanyJobDto;
import com.interna.gatewayservice.dto.job.JobDto;
import com.interna.gatewayservice.dto.job.JobSearchDto;
import com.interna.gatewayservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/job")
public class JobController {

    private final JobService jobService;


    @PostMapping
    public ResponseEntity<ApiResponse<String>> addJob(@RequestBody JobDto jobDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(jobService.addJob(jobDto))
                                .build()
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<JobDto>> getJob(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<JobDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(jobService.getJob(id))
                        .build()
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<String>> updateJob(@RequestBody JobDto jobDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.ACCEPTED.value())
                                .status(HttpStatus.ACCEPTED.name())
                                .timestamp(LocalDateTime.now())
                                .data(jobService.updateJob(jobDto))
                                .build()
                );
    }

    @GetMapping("company/{id}")
    public ResponseEntity<ApiResponse<List<CompanyJobDto>>> getCompanyJobs(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<List<CompanyJobDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(jobService.getCompanyJobs(id))
                        .build()
        );
    }

    @PostMapping("search")
    public ResponseEntity<ApiResponse<List<JobDto>>> search(@RequestBody JobSearchDto jobSearchDto) {
        return ResponseEntity.ok(
                ApiResponse.<List<JobDto>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(jobService.search(jobSearchDto))
                        .build()
        );
    }

}
