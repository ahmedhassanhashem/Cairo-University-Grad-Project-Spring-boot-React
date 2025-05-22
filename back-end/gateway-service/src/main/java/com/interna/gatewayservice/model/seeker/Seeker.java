package com.interna.gatewayservice.model.seeker;


import com.interna.gatewayservice.model.country.City;
import com.interna.gatewayservice.model.country.Country;
import com.interna.gatewayservice.model.link.Link;
import com.interna.gatewayservice.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "USERS_SEEKER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Seeker {

    @Id
    private String id;
    @Column(name = "SEEKER_NAME")
    private String seekerName;
    private String email;
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;
    private String position;
    private String summary;
    @OneToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    @OneToOne
    @JoinColumn(name = "CITY_ID")
    private City city;
    private String address;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToOne
    @JoinColumn(name = "LINKS_ID")
    private Link links;
    @Column(name = "IMG_PROFILE")
    private String profile;


}
