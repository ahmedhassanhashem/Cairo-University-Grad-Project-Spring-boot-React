package com.interna.gatewayservice.model.link;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "USERS_LINKS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Link {
    @Id
    private String id;
    private String facebook;
    private String twitter;
    private String linkedin;
    private String google;
    private String github;
    private String dribble;
    private String behance;
}
