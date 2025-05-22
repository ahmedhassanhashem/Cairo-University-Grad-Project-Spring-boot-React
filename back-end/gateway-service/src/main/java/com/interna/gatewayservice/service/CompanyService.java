package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.DuplicationDataException;
import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.company.CompanyDto;
import com.interna.gatewayservice.dto.company.CompanyDtoToCompanyMapper;
import com.interna.gatewayservice.dto.company.CompanyToCompanyDtoMapper;
import com.interna.gatewayservice.model.company.Company;
import com.interna.gatewayservice.repository.CompanyRepository;
import com.interna.gatewayservice.repository.LinkRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final LinkRepository linkRepository;


    public String addCompany(CompanyDto companyDto) {
        new ObjectsValidator<CompanyDto>().apply(companyDto);
        checkCompanyIdIsExist(companyDto.getUser().getId());
        checkCompanyEmailIsExist(companyDto.getEmail());
        checkCompanyUserIsExist(companyDto.getUser().getId());
        linkRepository.save(companyDto.getLinks());
        Company company = companyRepository.save(
                new CompanyDtoToCompanyMapper().apply(companyDto)
        );
        return company.getId();
    }

    public CompanyDto getCompany(String id) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException("Company is not found")
        );
        return new CompanyToCompanyDtoMapper().apply(company);
    }

    public String updateCompany(CompanyDto companyDto) {
        new ObjectsValidator<CompanyDto>().apply(companyDto);
        companyRepository.findById(companyDto.getId()).orElseThrow(
                () -> new NoResourceExistException("Company is not found")
        );
        linkRepository.save(companyDto.getLinks());
        companyRepository.save(
                new CompanyDtoToCompanyMapper().apply(companyDto)
        );
        return "Company profile updated successfully";
    }

    private void checkCompanyIdIsExist(String id) {
        if (companyRepository.findById(id).isPresent()) {
            throw new DuplicationDataException(String.format(String.format("Company '%s' is already exist.", id)));
        }
    }

    private void checkCompanyEmailIsExist(String email) {
        if (companyRepository.findByEmail(email).isPresent()) {
            throw new DuplicationDataException(String.format(String.format("Company email '%s' is already exist.", email)));
        }
    }

    private void checkCompanyUserIsExist(String userId) {
        if (companyRepository.findByUserId(userId).isPresent()) {
            throw new DuplicationDataException("The user already has a company.");
        }
    }

}
