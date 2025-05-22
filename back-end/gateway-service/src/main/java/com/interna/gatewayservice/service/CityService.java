package com.interna.gatewayservice.service;


import com.interna.gatewayservice.model.country.City;
import com.interna.gatewayservice.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;


    public List<City> getCityListOfCountry(long id) {
        return cityRepository.findByCountryId(id);
    }

}
