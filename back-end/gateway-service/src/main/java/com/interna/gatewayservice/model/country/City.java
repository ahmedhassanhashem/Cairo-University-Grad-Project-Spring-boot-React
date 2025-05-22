package com.interna.gatewayservice.model.country;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ALL_COUNTRY_CITIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CITIES_SEQ", sequenceName = "CITIES_SEQ", initialValue = 1001)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Country country;
    private String name;

}
