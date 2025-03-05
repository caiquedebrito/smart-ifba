package com.ifba.smart.api.solo.domain;

import java.util.List;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.in.SensorDataService;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.solo.infra.persistence.repository.SoloSensorRepository;

public class SoloSensorService implements SensorDataService {

  private final SensorDataRepository soloDataRepository;

  public SoloSensorService(SoloSensorRepository soloDataRepository) {
    this.soloDataRepository = soloDataRepository;
  }

  @Override
  public void save(Float data) {
    var sensorData = new SensorData(data);
    soloDataRepository.save(sensorData);
  }

  @Override
  public void delete(Integer id) {
    soloDataRepository.delete(id);
  }

  @Override
  public void getSensorData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSensorData'");
  }

  @Override
  public List<SensorData> getAll() {
    return soloDataRepository.getAll();
  }
  
}
