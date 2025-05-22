package com.interna.gatewayservice.dto.seeker;

import com.interna.gatewayservice.model.seeker.Seeker;

import java.util.function.Function;

public class SeekerToSeekerJobDtoMapper implements Function<Seeker, SeekerJobDto> {
    @Override
    public SeekerJobDto apply(Seeker seeker) {
        return new SeekerJobDto(
                seeker.getId(),
                seeker.getSeekerName(),
                seeker.getEmail(),
                seeker.getDateOfBirth(),
                seeker.getMobileNumber(),
                seeker.getPosition(),
                seeker.getSummary(),
                seeker.getAddress(),
                seeker.getProfile()
        );
    }
}
