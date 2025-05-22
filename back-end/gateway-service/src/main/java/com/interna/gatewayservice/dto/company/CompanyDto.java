package com.interna.gatewayservice.dto.company;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.dto.country.CountryDto;
import com.interna.gatewayservice.dto.user.UserDto;
import com.interna.gatewayservice.model.country.City;
import com.interna.gatewayservice.model.industry.Industry;
import com.interna.gatewayservice.model.link.Link;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyDto {

    @NotBlank(message = "id is empty")
    private String id;
    @NotBlank(message = "company name is empty")
    private String companyName;
    @NotBlank(message = "email is empty")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Email format is not valid!")
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date foundedDate;
    private String description;
    @NotNull(message = "country is empty")
    private CountryDto country;
    @NotNull(message = "city is empty")
    private City city;
    private String zip;
    @NotBlank(message = "address is empty")
    private String address;
    @NotNull(message = "industry is empty")
    private Industry industry;
    private Link links;
    private String profile;
    @NotNull(message = "user is empty")
    private UserDto user;

}
