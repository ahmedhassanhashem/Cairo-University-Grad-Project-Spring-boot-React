package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.company.CompanyDto;
import com.interna.gatewayservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/company")
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping
    public ResponseEntity<ApiResponse<String>> addCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(companyService.addCompany(companyDto))
                                .build()
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<CompanyDto>> getCompany(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<CompanyDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(companyService.getCompany(id))
                        .build()
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<String>> updateCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.ACCEPTED.value())
                                .status(HttpStatus.ACCEPTED.name())
                                .timestamp(LocalDateTime.now())
                                .data(companyService.updateCompany(companyDto))
                                .build()
                );
    }

}
