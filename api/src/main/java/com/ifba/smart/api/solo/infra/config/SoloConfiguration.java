package com.ifba.smart.api.solo.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ifba.smart.api.solo.domain.SoloSensorService;
import com.ifba.smart.api.solo.infra.persistence.repository.SoloSensorRepository;

@Configuration
public class SoloConfiguration {
  
  @Bean
  public SoloSensorService soloSensorService(SoloSensorRepository soloSensorRepository) {
    return new SoloSensorService(soloSensorRepository);
  }

  @Bean
  public SoloSensorRepository soloSensorRepository() {
    return new SoloSensorRepository();
  }
}
