package com.ifba.smart.api.humidity.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.smart.api.humidity.infra.persistence.entity.HumidityDataEntity;

public interface JpaHumidityDataRepo extends JpaRepository<HumidityDataEntity, Integer> {
  
}
