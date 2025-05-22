package com.interna.gatewayservice.dto.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PasswordUpdatingDto {

    @NotBlank(message = "User Id is empty!")
    private String userId;
    @NotBlank(message = "current password is empty!")
    private String currentPassword;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",
            message = "password format required is not valid (8 characters at least required)!")
    private String newPassword;

}
