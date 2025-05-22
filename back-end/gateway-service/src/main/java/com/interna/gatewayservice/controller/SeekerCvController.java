package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.dto.cv.SeekerCvDto;
import com.interna.gatewayservice.service.SeekerCvService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/seeker/cv2")
public class SeekerCvController {

    private final SeekerCvService seekerCvService;


    @PostMapping
    public ResponseEntity<ApiResponse<String>> addCv(@RequestBody SeekerCvDto seekerCvDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(seekerCvService.addCv(seekerCvDto))
                                .build()
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<SeekerCvDto>> getCv(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<SeekerCvDto>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(seekerCvService.getCv(id))
                        .build()
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<String>> updateCv(@RequestBody SeekerCvDto seekerCvDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.ACCEPTED.value())
                                .status(HttpStatus.ACCEPTED.name())
                                .timestamp(LocalDateTime.now())
                                .data(seekerCvService.updateCv(seekerCvDto))
                                .build()
                );
    }

}
