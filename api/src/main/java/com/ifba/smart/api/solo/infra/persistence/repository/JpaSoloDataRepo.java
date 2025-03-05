package com.ifba.smart.api.solo.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.smart.api.solo.infra.persistence.entity.SoloDataEntity;

public interface JpaSoloDataRepo extends JpaRepository<SoloDataEntity, Integer> {
  
}
