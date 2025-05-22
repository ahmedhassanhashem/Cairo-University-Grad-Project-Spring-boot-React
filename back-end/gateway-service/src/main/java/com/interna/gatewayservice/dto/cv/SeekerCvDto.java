package com.interna.gatewayservice.dto.cv;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.model.cv.EducationalQualification;
import com.interna.gatewayservice.model.cv.WorkExperience;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeekerCvDto {

    @NotBlank(message = "id is empty")
    private String id;
    @NotBlank(message = "seeker name is empty")
    private String seekerName;
    @NotBlank(message = "email is empty")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Email format is not valid!")
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @NotBlank(message = "mobile number is empty")
    private String mobileNumber;
    @NotBlank(message = "position is empty")
    private String position;
    private String summary;
    private List<EducationalQualification> educationalQualifications;
    private List<WorkExperience> workExperiences;

}
