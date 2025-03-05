package com.ifba.smart.api.sound.infra.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.sound.infra.persistence.entity.SoundDataEntity;

public class SoundSensorRepository implements SensorDataRepository {
  @Autowired
  private JpaSoundDataRepo jpaSoundDataRepo;

  @Override
  public void save(SensorData sensorData) {
    var soundDataEntity = new SoundDataEntity(sensorData.getData(), sensorData.getTimestamp());
    jpaSoundDataRepo.save(soundDataEntity);
  }

  @Override
  public void delete(Integer id) {
    jpaSoundDataRepo.deleteById(id);
  }

  @Override
  public SensorData findById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<SensorData> getAll() {
    List<SoundDataEntity> soundDataEntities = jpaSoundDataRepo.findAll();
    return soundDataEntities.stream()
                           .map(entity -> new SensorData(entity.getId(), entity.getData(), entity.getTimestamp()))
                           .toList();
  }
  
}
