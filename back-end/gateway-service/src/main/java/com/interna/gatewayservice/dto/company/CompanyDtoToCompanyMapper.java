package com.interna.gatewayservice.dto.company;

import com.interna.gatewayservice.model.company.Company;
import com.interna.gatewayservice.model.country.Country;
import com.interna.gatewayservice.model.user.User;

import java.util.function.Function;

public class CompanyDtoToCompanyMapper implements Function<CompanyDto, Company> {
    @Override
    public Company apply(CompanyDto companyDto) {
        User user = new User();
        user.setId(companyDto.getUser().getId());
        Country country = new Country();
        country.setId(companyDto.getCountry().getId());
        return new Company(
                companyDto.getUser().getId(),
                companyDto.getCompanyName(),
                companyDto.getEmail(),
                companyDto.getFoundedDate(),
                companyDto.getDescription(),
                country,
                companyDto.getCity(),
                companyDto.getZip(),
                companyDto.getAddress(),
                user,
                companyDto.getIndustry(),
                companyDto.getLinks(),
                companyDto.getProfile(),
                null
        );
    }
}
