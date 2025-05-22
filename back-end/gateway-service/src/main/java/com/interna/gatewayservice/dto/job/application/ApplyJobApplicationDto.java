package com.interna.gatewayservice.dto.job.application;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.dto.job.CompanyJobDto;
import com.interna.gatewayservice.dto.seeker.SeekerJobDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApplyJobApplicationDto {

    private String id;
    @NotBlank(message = "status is empty")
    private String status;
    @NotNull(message = "job is empty")
    private CompanyJobDto job;
    @NotNull(message = "seeker is empty")
    private SeekerJobDto seeker;
    private String feedback;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appliedDate;

}
