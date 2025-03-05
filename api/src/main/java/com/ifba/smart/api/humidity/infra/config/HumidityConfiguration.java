package com.ifba.smart.api.humidity.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ifba.smart.api.humidity.domain.HumiditySensorService;
import com.ifba.smart.api.humidity.infra.persistence.repository.HumiditySensorRepository;

@Configuration
public class HumidityConfiguration {
  
  @Bean
  public HumiditySensorService humiditySensorService(HumiditySensorRepository humiditySensorRepository) {
    return new HumiditySensorService(humiditySensorRepository);
  }

  @Bean
  public HumiditySensorRepository humiditySensorRepository() {
    return new HumiditySensorRepository();
  }
}
