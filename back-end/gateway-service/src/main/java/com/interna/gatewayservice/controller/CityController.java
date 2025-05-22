package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.model.country.City;
import com.interna.gatewayservice.service.CityService;
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
@RequestMapping(path = "api/gateway/city")
public class CityController {

    private final CityService cityService;


    @GetMapping("country/{id}")
    public ResponseEntity<ApiResponse<List<City>>> getCityListOfCountry(@PathVariable long id) {
        return ResponseEntity.ok(
                ApiResponse.<List<City>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(cityService.getCityListOfCountry(id))
                        .build()
        );
    }

}
