package com.ifba.smart.api.sound.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.smart.api.sound.infra.persistence.entity.SoundDataEntity;

public interface JpaSoundDataRepo extends JpaRepository<SoundDataEntity, Integer> {
  
}
