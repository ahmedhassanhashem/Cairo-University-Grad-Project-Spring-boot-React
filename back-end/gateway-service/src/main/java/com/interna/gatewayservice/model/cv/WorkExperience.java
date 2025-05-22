package com.interna.gatewayservice.model.cv;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "CV_WORK_EXPERIENCES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORK_EXPERIENCES_SEQ")
    @SequenceGenerator(name = "WORK_EXPERIENCES_SEQ", sequenceName = "WORK_EXPERIENCES_SEQ", initialValue = 1000001, allocationSize = 1)
    private long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private SeekerCv cv;
    private String position;
    private String companyName;
    @Column(name = "FROM_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date from;
    @Column(name = "TO_DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date to;
    @Column(name = "JOB_TYPE")
    private String jobType;
    private String responsibilities;

}
