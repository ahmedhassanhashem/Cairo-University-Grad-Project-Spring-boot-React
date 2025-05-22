package com.interna.gatewayservice.repository;


import com.interna.gatewayservice.model.appconfig.AppConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppConfigRepository extends JpaRepository<AppConfig, String> {

    List<AppConfig> findByKeyIn(List<String> keys);

}
