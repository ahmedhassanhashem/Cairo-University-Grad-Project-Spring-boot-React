package com.interna.gatewayservice.dto.seeker;

import com.interna.gatewayservice.model.seeker.Seeker;

import java.util.function.Function;

public class SeekerJobDtoToSeekerMapper implements Function<SeekerJobDto, Seeker> {
    @Override
    public Seeker apply(SeekerJobDto seekerJobDto) {
        return new Seeker(
                seekerJobDto.getId(),
                seekerJobDto.getSeekerName(),
                seekerJobDto.getEmail(),
                seekerJobDto.getDateOfBirth(),
                seekerJobDto.getMobileNumber(),
                seekerJobDto.getPosition(),
                seekerJobDto.getSummary(),
                null,
                null,
                seekerJobDto.getAddress(),
                null,
                null,
                seekerJobDto.getProfile());
    }
}
