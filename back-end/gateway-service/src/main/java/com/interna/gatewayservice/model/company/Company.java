package com.interna.gatewayservice.model.company;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.interna.gatewayservice.model.country.City;
import com.interna.gatewayservice.model.country.Country;
import com.interna.gatewayservice.model.industry.Industry;
import com.interna.gatewayservice.model.job.Job;
import com.interna.gatewayservice.model.link.Link;
import com.interna.gatewayservice.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS_COMPANY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Company {

    @Id
    private String id;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    private String email;
    @Column(name = "FOUNDED_DATE")
    private Date foundedDate;
    private String description;
    @OneToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    @OneToOne
    @JoinColumn(name = "CITY_ID")
    private City city;
    private String zip;
    private String address;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToOne
    @JoinColumn(name = "INDUSTRY_ID")
    private Industry industry;
    @OneToOne
    @JoinColumn(name = "LINKS_ID")
    private Link links;
    @Column(name = "IMG_PROFILE")
    private String profile;
    @OneToMany
    @JoinColumn(name = "COMPANY_ID")
    @JsonIgnore
    private List<Job> jobs;
}
