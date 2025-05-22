package com.interna.gatewayservice.base.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private String path;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;

}
