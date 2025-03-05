package com.ifba.smart.api.sound.domain;

import java.util.List;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.domain.ports.in.SensorDataService;
import com.ifba.smart.api.domain.ports.out.SensorDataRepository;
import com.ifba.smart.api.sound.infra.persistence.repository.SoundSensorRepository;

public class SoundSensorService implements SensorDataService {

  private final SensorDataRepository soundSensorRepository;

  public SoundSensorService(SoundSensorRepository soundSensorRepository) {
    this.soundSensorRepository = soundSensorRepository;
  }

  @Override
  public void save(Float data) {
    var sensorData = new SensorData(data);
    soundSensorRepository.save(sensorData);
  }

  @Override
  public void delete(Integer id) {
    soundSensorRepository.delete(id);
  }

  @Override
  public void getSensorData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getSensorData'");
  }

  @Override
  public List<SensorData> getAll() {
    return soundSensorRepository.getAll();
  }
  
}
