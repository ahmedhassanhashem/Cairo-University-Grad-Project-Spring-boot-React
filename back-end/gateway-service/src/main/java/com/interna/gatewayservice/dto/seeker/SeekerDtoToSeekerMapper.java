package com.interna.gatewayservice.dto.seeker;

import com.interna.gatewayservice.model.country.Country;
import com.interna.gatewayservice.model.seeker.Seeker;
import com.interna.gatewayservice.model.user.User;

import java.util.List;
import java.util.function.Function;

public class SeekerDtoToSeekerMapper implements Function<SeekerDto, Seeker> {
    @Override
    public Seeker apply(SeekerDto seekerDto) {
        User user = new User();
        user.setId(seekerDto.getUser().getId());
        Country country = new Country();
        country.setId(seekerDto.getCountry().getId());
        System.out.println("seekerDto = " + seekerDto);
        return new Seeker(
                seekerDto.getUser().getId(),
                seekerDto.getSeekerName(),
                seekerDto.getEmail(),
                seekerDto.getDateOfBirth(),
                seekerDto.getMobileNumber(),
                seekerDto.getPosition(),
                seekerDto.getSummary(),
                country,
                seekerDto.getCity(),
                seekerDto.getAddress(),
                user,
                seekerDto.getLinks(),
                seekerDto.getProfile()
        );
    }
}
