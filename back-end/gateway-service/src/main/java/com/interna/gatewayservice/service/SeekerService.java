package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.DuplicationDataException;
import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.seeker.SeekerDto;
import com.interna.gatewayservice.dto.seeker.SeekerDtoToSeekerMapper;
import com.interna.gatewayservice.dto.seeker.SeekerToSeekerDtoMapper;
import com.interna.gatewayservice.model.seeker.Seeker;
import com.interna.gatewayservice.repository.LinkRepository;
import com.interna.gatewayservice.repository.SeekerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class SeekerService {

    private final SeekerRepository seekerRepository;
    private final LinkRepository linkRepository;


    public String addSeeker(SeekerDto seekerDto) {
        new ObjectsValidator<SeekerDto>().apply(seekerDto);
        checkSeekerIdIsExist(seekerDto.getUser().getId());
        checkSeekerEmailIsExist(seekerDto.getEmail());
        checkSeekerUserIsExist(seekerDto.getUser().getId());
        linkRepository.save(seekerDto.getLinks());
        Seeker seeker = seekerRepository.save(
                new SeekerDtoToSeekerMapper().apply(seekerDto)
        );
        return seeker.getId();
    }

    public SeekerDto getSeeker(String id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException("Seeker is not found")
        );
        return new SeekerToSeekerDtoMapper().apply(seeker);
    }

    public String updateSeeker(SeekerDto seekerDto) {
        new ObjectsValidator<SeekerDto>().apply(seekerDto);
        seekerRepository.findById(seekerDto.getId()).orElseThrow(
                () -> new NoResourceExistException("Seeker is not found")
        );
        linkRepository.save(seekerDto.getLinks());
        seekerRepository.save(
                new SeekerDtoToSeekerMapper().apply(seekerDto)
        );
        return "Seeker profile updated successfully";
    }

    private void checkSeekerIdIsExist(String id) {
        if (seekerRepository.findById(id).isPresent()) {
            throw new DuplicationDataException(String.format(String.format("Seeker '%s' is already exist.", id)));
        }
    }

    private void checkSeekerEmailIsExist(String email) {
        if (seekerRepository.findByEmail(email).isPresent()) {
            throw new DuplicationDataException(String.format(String.format("Seeker email '%s' is already exist.", email)));
        }
    }

    private void checkSeekerUserIsExist(String userId) {
        if (seekerRepository.findByUserId(userId).isPresent()) {
            throw new DuplicationDataException("The user already has a seeker.");
        }
    }

}
