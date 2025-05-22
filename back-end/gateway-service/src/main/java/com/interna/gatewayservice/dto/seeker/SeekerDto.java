package com.interna.gatewayservice.dto.seeker;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.dto.country.CountryDto;
import com.interna.gatewayservice.dto.user.UserDto;
import com.interna.gatewayservice.model.country.City;
import com.interna.gatewayservice.model.link.Link;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeekerDto {

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
    @NotNull(message = "country is empty")
    private CountryDto country;
    @NotNull(message = "city is empty")
    private City city;
    @NotBlank(message = "address is empty")
    private String address;
    private Link links;
    private String profile;
    @NotNull(message = "user is empty")
    private UserDto user;

}
