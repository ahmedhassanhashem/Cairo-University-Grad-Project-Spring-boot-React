package com.interna.gatewayservice.model.country;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ALL_COUNTRIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COUNTRIES_SEQ", sequenceName = "COUNTRIES_SEQ", initialValue = 101)
    private long id;
    private String name;
    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
