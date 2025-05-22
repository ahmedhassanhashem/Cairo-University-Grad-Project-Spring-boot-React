package com.interna.gatewayservice.dto.user;


import com.interna.gatewayservice.dto.role.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private String id;
    private String name;
    private String email;
    private RoleDto role;
    private boolean enabled;
    private boolean locked;
    private boolean expired;
    private LocalDateTime createdDate;

}
