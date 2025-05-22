package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.seeker.SeekerDto;
import com.interna.gatewayservice.service.SeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/seeker")
public class SeekerController {

    private final SeekerService seekerService;


    @PostMapping
    public ResponseEntity<ApiResponse<String>> addSeeker(@RequestBody SeekerDto seekerDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(seekerService.addSeeker(seekerDto))
                                .build()
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<SeekerDto>> getSeeker(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<SeekerDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(seekerService.getSeeker(id))
                        .build()
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<String>> updateSeeker(@RequestBody SeekerDto seekerDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.ACCEPTED.value())
                                .status(HttpStatus.ACCEPTED.name())
                                .timestamp(LocalDateTime.now())
                                .data(seekerService.updateSeeker(seekerDto))
                                .build()
                );
    }

}
