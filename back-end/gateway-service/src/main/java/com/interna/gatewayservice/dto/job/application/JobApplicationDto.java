package com.interna.gatewayservice.dto.job.application;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.dto.job.JobDto;
import com.interna.gatewayservice.dto.seeker.SeekerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobApplicationDto {

    private String id;
    private String status;
    private JobDto job;
    private SeekerDto seeker;
    private String feedback;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appliedDate;

}
