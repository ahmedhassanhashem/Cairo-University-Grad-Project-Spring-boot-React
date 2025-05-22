package com.interna.gatewayservice.model.job;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.interna.gatewayservice.model.seeker.Seeker;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SEEKER_JOBS_APPLIED")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Job job;
    @ManyToOne(fetch = FetchType.LAZY)
    private Seeker seeker;
    private String status;
    private String feedback;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

}
