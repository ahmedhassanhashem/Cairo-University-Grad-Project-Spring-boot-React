package com.interna.gatewayservice.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {

    @JsonProperty(value = "access_token")
    private String token;
    @JsonProperty(value = "refresh_token")
    private String refresh;

}
