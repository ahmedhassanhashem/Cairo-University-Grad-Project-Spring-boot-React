package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.model.cv.UserSeekerCv;
import com.interna.gatewayservice.service.UserSeekerCvService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/gateway/seeker/cv")
public class UserSeekerCvController {

    private final UserSeekerCvService userSeekerCvService;


    @PostMapping
    public ResponseEntity<ApiResponse<String>> addCv(@RequestBody UserSeekerCv seekerCvDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .status(HttpStatus.CREATED.name())
                                .timestamp(LocalDateTime.now())
                                .data(userSeekerCvService.addCv(seekerCvDto))
                                .build()
                );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<UserSeekerCv>> getCv(@PathVariable String id) {
        return ResponseEntity.ok(
                ApiResponse.<UserSeekerCv>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(userSeekerCvService.getCv(id))
                        .build()
        );
    }

    @PutMapping("update")
    public ResponseEntity<ApiResponse<String>> updateCv(@RequestBody UserSeekerCv seekerCvDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(HttpStatus.ACCEPTED.value())
                                .status(HttpStatus.ACCEPTED.name())
                                .timestamp(LocalDateTime.now())
                                .data(userSeekerCvService.updateCv(seekerCvDto))
                                .build()
                );
    }

}
