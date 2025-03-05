package com.ifba.smart.api.temperature.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.smart.api.temperature.infra.persistence.entity.TemperatureDataEntity;

public interface JpaTemperatureDataRepo extends JpaRepository<TemperatureDataEntity, Integer> {
  
}
