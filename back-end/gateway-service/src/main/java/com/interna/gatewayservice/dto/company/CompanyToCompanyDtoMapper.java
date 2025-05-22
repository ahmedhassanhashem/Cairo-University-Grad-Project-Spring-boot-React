package com.interna.gatewayservice.dto.company;

import com.interna.gatewayservice.dto.country.CountryToCountryDtoMapper;
import com.interna.gatewayservice.dto.user.UserToUserDtoMapper;
import com.interna.gatewayservice.model.company.Company;

import java.util.function.Function;

public class CompanyToCompanyDtoMapper implements Function<Company, CompanyDto> {
    @Override
    public CompanyDto apply(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getCompanyName(),
                company.getEmail(),
                company.getFoundedDate(),
                company.getDescription(),
                new CountryToCountryDtoMapper().apply(company.getCountry()),
                company.getCity(),
                company.getZip(),
                company.getAddress(),
                company.getIndustry(),
                company.getLinks(),
                company.getProfile(),
                new UserToUserDtoMapper().apply(company.getUser())
        );
    }
}
