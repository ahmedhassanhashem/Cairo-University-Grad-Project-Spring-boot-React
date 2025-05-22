package com.interna.gatewayservice.model.cv;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SEEKER_CV")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SeekerCv {

    @Id
    private String id;
    private String seekerName;
    private String email;
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;
    private String position;
    private String summary;
    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CV_ID")
    private List<EducationalQualification> educationalQualifications;
    @OneToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CV_ID")
    private List<WorkExperience> workExperiences;

}
