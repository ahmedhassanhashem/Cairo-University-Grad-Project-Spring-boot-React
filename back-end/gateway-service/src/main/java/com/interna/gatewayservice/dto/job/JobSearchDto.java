package com.interna.gatewayservice.dto.job;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobSearchDto {

    @NotBlank(message = "position is empty")
    private String position;
    private String jobType;
    private long cityId;

}
