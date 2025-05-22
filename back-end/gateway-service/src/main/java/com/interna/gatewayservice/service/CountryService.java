package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.model.country.Country;
import com.interna.gatewayservice.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }

    public Country getCountry(long id) {
        return countryRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException(String.format("Country id '%s' is not found", id))
        );
    }

}
