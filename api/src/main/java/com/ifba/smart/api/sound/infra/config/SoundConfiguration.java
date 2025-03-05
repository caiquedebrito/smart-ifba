package com.ifba.smart.api.sound.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ifba.smart.api.sound.domain.SoundSensorService;
import com.ifba.smart.api.sound.infra.persistence.repository.SoundSensorRepository;

@Configuration
public class SoundConfiguration {
  
  @Bean
  public SoundSensorService soundSensorService(SoundSensorRepository soundSensorRepository) {
    return new SoundSensorService(soundSensorRepository);
  }

  @Bean
  public SoundSensorRepository soundSensorRepository() {
    return new SoundSensorRepository();
  }
}
