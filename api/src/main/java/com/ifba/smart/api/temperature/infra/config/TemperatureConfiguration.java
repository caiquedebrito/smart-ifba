package com.ifba.smart.api.temperature.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ifba.smart.api.temperature.domain.TemperatureSensorService;
import com.ifba.smart.api.temperature.infra.persistence.repository.TemperatureSensorRepository;

@Configuration
public class TemperatureConfiguration {
  
  @Bean
  public TemperatureSensorService temperatureSensorService(TemperatureSensorRepository temperatureSensorRepository) {
    return new TemperatureSensorService(temperatureSensorRepository);
  }

  @Bean
  public TemperatureSensorRepository temperatureSensorRepository() {
    return new TemperatureSensorRepository();
  }
}
