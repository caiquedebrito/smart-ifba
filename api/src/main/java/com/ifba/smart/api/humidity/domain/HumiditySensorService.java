package com.ifba.smart.api.humidity.domain;

import java.util.List;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.in.SensorDataService;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.humidity.infra.persistence.repository.HumiditySensorRepository;

public class HumiditySensorService implements SensorDataService {

  private final SensorDataRepository humidityDataRepository;

  public HumiditySensorService(HumiditySensorRepository humidityDataRepository) {
    this.humidityDataRepository = humidityDataRepository;
  }

  @Override
  public void save(Float data) {
    var sensorData = new SensorData(data);
    humidityDataRepository.save(sensorData);
  }

  @Override
  public void delete(Integer id) {
    humidityDataRepository.delete(id);
  }

  @Override
  public void getSensorData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSensorData'");
  }

  @Override
  public List<SensorData> getAll() {
    return humidityDataRepository.getAll();
  }
  
}
