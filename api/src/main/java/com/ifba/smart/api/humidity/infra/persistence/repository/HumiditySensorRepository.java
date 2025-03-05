package com.ifba.smart.api.humidity.infra.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.humidity.infra.persistence.entity.HumidityDataEntity;

public class HumiditySensorRepository implements SensorDataRepository {

  @Autowired
  private JpaHumidityDataRepo jpaHumiditySensorRepo;

  @Override
  public void delete(Integer id) {
    jpaHumiditySensorRepo.deleteById(id);
  }

  @Override
  public SensorData findById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<SensorData> getAll() {
    List<HumidityDataEntity> humidityDataEntities = jpaHumiditySensorRepo.findAll();
    return humidityDataEntities.stream()
                           .map(entity -> new SensorData(entity.getId(), entity.getData(), entity.getTimestamp()))
                           .toList();
  }

  @Override
  public void save(SensorData sensorData) {
    var humidityDataEntity = new HumidityDataEntity(sensorData.getData(), sensorData.getTimestamp());
    jpaHumiditySensorRepo.save(humidityDataEntity);
  }
  
}
