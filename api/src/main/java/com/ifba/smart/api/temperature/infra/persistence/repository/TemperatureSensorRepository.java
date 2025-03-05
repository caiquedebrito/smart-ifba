package com.ifba.smart.api.temperature.infra.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.temperature.infra.persistence.entity.TemperatureDataEntity;

public class TemperatureSensorRepository implements SensorDataRepository {
  @Autowired
  private JpaTemperatureDataRepo jpaTemperatureDataRepo;

  @Override
  public void save(SensorData sensorData) {
    var temperatureData = new TemperatureDataEntity(sensorData.getData(), sensorData.getTimestamp());
    jpaTemperatureDataRepo.save(temperatureData);
  }

  @Override
  public void delete(Integer id) {
    jpaTemperatureDataRepo.deleteById(id);
  }

  @Override
  public SensorData findById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<SensorData> getAll() {
    List<TemperatureDataEntity> temperatureDataEntities = jpaTemperatureDataRepo.findAll();
    return temperatureDataEntities.stream()
                           .map(entity -> new SensorData(entity.getId(), entity.getData(), entity.getTimestamp()))
                           .toList();
  }
  
}
