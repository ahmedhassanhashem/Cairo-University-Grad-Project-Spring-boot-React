package com.interna.gatewayservice.dto.job;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.dto.company.CompanyDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobDto {

    private String id;
    @NotBlank(message = "Position is empty!")
    private String position;
    @NotBlank(message = "Job Level is empty!")
    private String jobLevel;
    @NotBlank(message = "Experience is empty!")
    private String experience;
    @NotBlank(message = "Job Type is empty!")
    private String jobType;
    @NotBlank(message = "Description is empty!")
    private String description;
    @NotBlank(message = "Requirements is empty!")
    private String requirements;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date deadLine;
    private boolean open;
    private CompanyDto company;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
}
