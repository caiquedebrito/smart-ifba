package com.ifba.smart.api.domain.ports.out;

import java.util.List;

import com.ifba.smart.api.domain.model.SensorData;

public interface SensorDataRepository {
  void save(SensorData sensorData);
  void delete(Integer id);
  SensorData findById(String id);
  List<SensorData> getAll();
}
