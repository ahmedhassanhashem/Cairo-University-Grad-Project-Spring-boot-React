package com.interna.gatewayservice.dto.cv;

import com.interna.gatewayservice.dto.seeker.SeekerToSeekerDtoMapper;
import com.interna.gatewayservice.model.cv.SeekerCv;

import java.util.function.Function;

public class SeekerCvToSeekerCvDtoMapper implements Function<SeekerCv, SeekerCvDto> {
    @Override
    public SeekerCvDto apply(SeekerCv seekerCv) {
        return new SeekerCvDto(
                seekerCv.getId(),
                seekerCv.getSeekerName(),
                seekerCv.getEmail(),
                seekerCv.getDateOfBirth(),
                seekerCv.getMobileNumber(),
                seekerCv.getPosition(),
                seekerCv.getSummary(),
                seekerCv.getEducationalQualifications(),
                seekerCv.getWorkExperiences()
        );
    }
}
