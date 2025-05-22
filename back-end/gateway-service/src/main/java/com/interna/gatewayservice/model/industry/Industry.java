package com.interna.gatewayservice.model.industry;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ALL_INDUSTRIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Industry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "INDUSTRIES_SEQ", sequenceName = "INDUSTRIES_SEQ", initialValue = 1001)
    private long id;
    private String name;

}
