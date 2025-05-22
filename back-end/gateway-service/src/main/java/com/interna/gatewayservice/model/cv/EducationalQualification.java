package com.interna.gatewayservice.model.cv;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CV_EDUCATIONAL_QUALIFICATIONS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EducationalQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATIONAL_QUALIFICATIONS_SEQ")
    @SequenceGenerator(name = "EDUCATIONAL_QUALIFICATIONS_SEQ", sequenceName = "EDUCATIONAL_QUALIFICATIONS_SEQ", initialValue = 1000001, allocationSize = 1)
    private long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private SeekerCv cv;
    @Column(name = "SCHOOL_NAME")
    private String schoolName;
    @Column(name = "EDUCATION_LEVEL")
    private String educationalLevel;
    private String major;
    private String gpa;

}
