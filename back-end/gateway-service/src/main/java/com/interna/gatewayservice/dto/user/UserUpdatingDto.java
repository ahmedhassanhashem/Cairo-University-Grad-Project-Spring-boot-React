package com.interna.gatewayservice.dto.user;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserUpdatingDto {

    @NotBlank(message = "User Id is empty!")
    private String userId;
    @NotBlank(message = "First name is empty!")
    private String firstName;
    @NotBlank(message = "Last name is empty!")
    private String lastName;

}
