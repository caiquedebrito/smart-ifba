package com.ifba.smart.api.solo.infra.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.solo.infra.persistence.entity.SoloDataEntity;

public class SoloSensorRepository implements SensorDataRepository {
  @Autowired
  private JpaSoloDataRepo jpaSoloDataRepo;

  @Override
  public void save(SensorData sensorData) {
    var soloDataEntity = new SoloDataEntity(sensorData.getData(), sensorData.getTimestamp());
    jpaSoloDataRepo.save(soloDataEntity);
  }

  @Override
  public void delete(Integer id) {
    jpaSoloDataRepo.deleteById(id);
  }

  @Override
  public SensorData findById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<SensorData> getAll() {
    List<SoloDataEntity> soloDataEntities = jpaSoloDataRepo.findAll();
    return soloDataEntities.stream()
                           .map(entity -> new SensorData(entity.getId(), entity.getData(), entity.getTimestamp()))
                           .toList();
  }
  
}
