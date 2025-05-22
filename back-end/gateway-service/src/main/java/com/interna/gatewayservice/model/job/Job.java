package com.interna.gatewayservice.model.job;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.interna.gatewayservice.model.company.Company;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "JOBS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String position;
    private String jobLevel;
    private String experience;
    private String jobType;
    private String description;
    private String requirements;
    @Column(name = "DEADLINE")
    private Date deadLine;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @Column(name = "OPENED")
    private boolean open;
    @OneToMany()
    @JoinColumn(name = "JOB_ID")
    @JsonIgnore
    List<JobApplication> jobApplications;

}
