package com.interna.gatewayservice.service;


import com.interna.gatewayservice.base.exception.NoResourceExistException;
import com.interna.gatewayservice.model.appconfig.AppConfig;
import com.interna.gatewayservice.repository.AppConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AppConfigService {

    private final AppConfigRepository appConfigRepository;

    private final Logger logger = Logger.getLogger(AppConfigService.class.getName());


    public String getConfigurationValue(String key) {
        return appConfigRepository.findById(key)
                .orElseThrow(
                        () -> new NoResourceExistException("Key " + key + "is not found!")
                ).getValue();
    }

    public List<AppConfig> getListOfConfigurations(List<String> Keys) {
        return appConfigRepository.findByKeyIn(Keys);
    }
}
