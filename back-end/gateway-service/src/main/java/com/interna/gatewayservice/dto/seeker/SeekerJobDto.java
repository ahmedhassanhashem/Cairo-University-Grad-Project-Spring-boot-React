package com.interna.gatewayservice.dto.seeker;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeekerJobDto {

    private String id;
    private String seekerName;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String mobileNumber;
    private String position;
    private String summary;
    private String address;
    private String profile;

}
