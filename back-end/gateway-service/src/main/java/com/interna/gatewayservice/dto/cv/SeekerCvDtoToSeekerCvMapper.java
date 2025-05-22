package com.interna.gatewayservice.dto.cv;

import com.interna.gatewayservice.dto.seeker.SeekerDtoToSeekerMapper;
import com.interna.gatewayservice.model.cv.SeekerCv;

import java.util.function.Function;

public class SeekerCvDtoToSeekerCvMapper implements Function<SeekerCvDto, SeekerCv> {
    @Override
    public SeekerCv apply(SeekerCvDto seekerCvDto) {
        return new SeekerCv(
                seekerCvDto.getId(),
                seekerCvDto.getSeekerName(),
                seekerCvDto.getEmail(),
                seekerCvDto.getDateOfBirth(),
                seekerCvDto.getMobileNumber(),
                seekerCvDto.getPosition(),
                seekerCvDto.getSummary(),
                seekerCvDto.getEducationalQualifications(),
                seekerCvDto.getWorkExperiences()
        );
    }
}
