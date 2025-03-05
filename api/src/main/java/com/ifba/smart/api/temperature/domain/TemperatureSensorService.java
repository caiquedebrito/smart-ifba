package com.ifba.smart.api.temperature.domain;

import java.util.List;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.in.SensorDataService;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.temperature.infra.persistence.repository.TemperatureSensorRepository;

public class TemperatureSensorService implements SensorDataService {

  private final SensorDataRepository temperatureSensorRepository;

  public TemperatureSensorService(TemperatureSensorRepository temperatureSensorRepository) {
    this.temperatureSensorRepository = temperatureSensorRepository;
  }

  @Override
  public void save(Float data) {
    var sensorData = new SensorData(data);
    temperatureSensorRepository.save(sensorData);
  }

  @Override
  public void delete(Integer id) {
    temperatureSensorRepository.delete(id);
  }

  @Override
  public void getSensorData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSensorData'");
  }

  @Override
  public List<SensorData> getAll() {
    return temperatureSensorRepository.getAll();
  }
  
}
