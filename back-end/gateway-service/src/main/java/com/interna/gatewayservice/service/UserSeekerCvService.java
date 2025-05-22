package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.DuplicationDataException;
import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.model.cv.UserSeekerCv;
import com.interna.gatewayservice.repository.UserSeekerCvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSeekerCvService {

    private final UserSeekerCvRepository userSeekerCvRepository;


    public String addCv(UserSeekerCv userSeekerCv) {
        if (userSeekerCvRepository.findById(userSeekerCv.getId()).isPresent()) {
            throw new DuplicationDataException("The user has already cv");
        }
        UserSeekerCv seekerCv = userSeekerCvRepository.save(userSeekerCv);
        return seekerCv.getId();
    }

    public UserSeekerCv getCv(String id) {
        return userSeekerCvRepository.findById(id).orElseThrow(
                () -> new NoResourceExistException("Cv is not found")
        );
    }

    public String updateCv(UserSeekerCv userSeekerCv) {
        getCv(userSeekerCv.getId());
        userSeekerCvRepository.save(userSeekerCv);
        return "cv update successfully";
    }

}
