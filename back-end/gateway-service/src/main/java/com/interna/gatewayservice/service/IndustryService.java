package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.model.industry.Industry;
import com.interna.gatewayservice.repository.IndustryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndustryService {

    private final IndustryRepository industryRepository;

    public List<Industry> getIndustryList() {
        return industryRepository.findAll();
    }

    public Industry getIndustry(long id) {
        return industryRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException(String.format("Industry id '%s' is not found", id))
        );
    }

}
