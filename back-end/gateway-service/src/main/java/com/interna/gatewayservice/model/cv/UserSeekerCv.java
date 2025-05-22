package com.interna.gatewayservice.model.cv;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "USERS_SEEKER_CV")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSeekerCv {

    @Id
    private String id;
    @Column(name = "CV_DATA")
    private String cv;

}
