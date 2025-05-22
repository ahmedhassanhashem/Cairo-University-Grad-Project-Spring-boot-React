package com.interna.gatewayservice.controller;


import com.interna.gatewayservice.base.model.ApiResponse;
import com.interna.gatewayservice.model.country.Country;
import com.interna.gatewayservice.service.CountryService;
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
@RequestMapping(path = "api/gateway/country")
public class CountryController {

    private final CountryService countryService;


    @GetMapping("list")
    public ResponseEntity<ApiResponse<List<Country>>> getCountryList() {
        return ResponseEntity.ok(
                ApiResponse.<List<Country>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(countryService.getCountryList())
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Country>> getCountry(@PathVariable long id) {
        return ResponseEntity.ok(
                ApiResponse.<Country>builder()
                        .statusCode(HttpStatus.OK.value())
                        .status(HttpStatus.OK.name())
                        .timestamp(LocalDateTime.now())
                        .data(countryService.getCountry(id))
                        .build()
        );
    }

}
