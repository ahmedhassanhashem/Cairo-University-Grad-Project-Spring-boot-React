package com.interna.gatewayservice.dto.seeker;

import com.interna.gatewayservice.dto.country.CountryToCountryDtoMapper;
import com.interna.gatewayservice.dto.user.UserToUserDtoMapper;
import com.interna.gatewayservice.model.seeker.Seeker;

import java.util.function.Function;

public class SeekerToSeekerDtoMapper implements Function<Seeker, SeekerDto> {
    @Override
    public SeekerDto apply(Seeker seeker) {
        return new SeekerDto(
                seeker.getId(),
                seeker.getSeekerName(),
                seeker.getEmail(),
                seeker.getDateOfBirth(),
                seeker.getMobileNumber(),
                seeker.getPosition(),
                seeker.getSummary(),
                new CountryToCountryDtoMapper().apply(seeker.getCountry()),
                seeker.getCity(),
                seeker.getAddress(),
                seeker.getLinks(),
                seeker.getProfile(),
                new UserToUserDtoMapper().apply(seeker.getUser())
        );
    }
}
