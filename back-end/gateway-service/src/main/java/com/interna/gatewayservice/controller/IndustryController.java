package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.model.industry.Industry;
import com.interna.gatewayservice.service.IndustryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/industry")
public class IndustryController {

    private final IndustryService industryService;


    @GetMapping("list")
    public ResponseEntity<ApiResponse<List<Industry>>> getIndustryList() {
        return ResponseEntity.ok(
                ApiResponse.<List<Industry>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(industryService.getIndustryList())
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Industry>> getIndustry(@PathVariable long id) {
        return ResponseEntity.ok(
                ApiResponse.<Industry>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(industryService.getIndustry(id))
                        .build()
        );
    }

}
