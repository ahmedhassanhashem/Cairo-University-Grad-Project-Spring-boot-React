package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.DuplicationDataException;
import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.base.validation.ObjectsValidator;
import com.interna.gatewayservice.dto.cv.SeekerCvDto;
import com.interna.gatewayservice.dto.cv.SeekerCvDtoToSeekerCvMapper;
import com.interna.gatewayservice.dto.cv.SeekerCvToSeekerCvDtoMapper;
import com.interna.gatewayservice.model.cv.SeekerCv;
import com.interna.gatewayservice.repository.EducationalQualificationRepository;
import com.interna.gatewayservice.repository.SeekerCvRepository;
import com.interna.gatewayservice.repository.WorkExperienceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SeekerCvService {

    private final SeekerCvRepository seekerCvRepository;
    private final EducationalQualificationRepository educationalQualificationRepository;
    private final WorkExperienceRepository workExperienceRepository;


    public String addCv(final SeekerCvDto seekerCvDto) {
        new ObjectsValidator<SeekerCvDto>().apply(seekerCvDto);
        checkSeekerCvIdIsExist(seekerCvDto.getId());
        SeekerCvDto seekerCvDtoTemp = new SeekerCvDto(
                seekerCvDto.getId(),
                seekerCvDto.getSeekerName(),
                seekerCvDto.getEmail(),
                seekerCvDto.getDateOfBirth(),
                seekerCvDto.getMobileNumber(),
                seekerCvDto.getPosition(),
                seekerCvDto.getSummary(),
                List.of(),
                List.of()
        );
        seekerCvRepository.saveAndFlush(
                new SeekerCvDtoToSeekerCvMapper().apply(seekerCvDtoTemp)
        );
        educationalQualificationRepository.saveAll(seekerCvDto.getEducationalQualifications());
        workExperienceRepository.saveAll(seekerCvDto.getWorkExperiences());
        SeekerCv SavedSeekerCv = seekerCvRepository.save(
                new SeekerCvDtoToSeekerCvMapper().apply(seekerCvDto)
        );
        return SavedSeekerCv.getId();
    }

    public SeekerCvDto getCv(String id) {
        SeekerCv seekerCv = seekerCvRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException("Cv is not found")
        );
        return new SeekerCvToSeekerCvDtoMapper().apply(seekerCv);
    }

    public String updateCv(SeekerCvDto seekerCvDto) {
        new ObjectsValidator<SeekerCvDto>().apply(seekerCvDto);
        seekerCvRepository.findById(seekerCvDto.getId()).orElseThrow(
                () -> new NoResourceExistException("cv is not found")
        );

        deleteEducationalQualifications(seekerCvDto.getId());
        deleteWorkExperiences(seekerCvDto.getId());

        educationalQualificationRepository.saveAll(seekerCvDto.getEducationalQualifications());
        workExperienceRepository.saveAll(seekerCvDto.getWorkExperiences());
        seekerCvRepository.saveAndFlush(
                new SeekerCvDtoToSeekerCvMapper().apply(seekerCvDto)
        );
        return "cv updated successfully";
    }

    private void deleteEducationalQualifications(String cvId) {
        educationalQualificationRepository.deleteAllByCvId(cvId);
        educationalQualificationRepository.flush();
    }

    private void deleteWorkExperiences(String cvId) {
        workExperienceRepository.deleteAllByCvId(cvId);
        workExperienceRepository.flush();
    }


    private void checkSeekerCvIdIsExist(String id) {
        if (seekerCvRepository.findById(id).isPresent()) {
            throw new DuplicationDataException(String.format(String.format("cv '%s' is already exist.", id)));
        }
    }


}
