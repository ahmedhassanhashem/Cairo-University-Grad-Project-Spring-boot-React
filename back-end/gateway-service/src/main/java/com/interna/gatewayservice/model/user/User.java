package com.interna.gatewayservice.model.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.interna.gatewayservice.model.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable, UserDetails {

    @Id
    @GenericGenerator(name = "USER_SEQUENCE",
            strategy = "com.interna.gatewayservice.model.user.UserPrefixedSequenceIdGenerator"
    )
    @GeneratedValue(generator = "USER_SEQUENCE")
    @Column(updatable = false, nullable = false)
    private String id;
    @Column(name = "FIRST_NAME")
    private String name;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;
    private boolean enabled;
    private boolean locked;
    private boolean expired;
    @Column(name = "CREATED_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(
                new SimpleGrantedAuthority(role.getName())
        );
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }
}
