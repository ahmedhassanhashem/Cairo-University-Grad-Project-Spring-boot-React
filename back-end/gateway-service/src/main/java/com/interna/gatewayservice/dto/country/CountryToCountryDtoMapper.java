package com.interna.gatewayservice.dto.country;

import com.interna.gatewayservice.model.country.Country;

import java.util.function.Function;

public class CountryToCountryDtoMapper implements Function<Country, CountryDto> {
    @Override
    public CountryDto apply(Country country) {
        return new CountryDto(
                country.getId(),
                country.getName()
        );
    }
}
