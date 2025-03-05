package com.ifba.smart.api.domain.ports.in;

import java.util.List;

import com.ifba.smart.api.domain.model.SensorData;

public interface SensorDataService {
  void save(Float data);
  void delete(Integer id);
  void getSensorData(String id);
  List<SensorData> getAll();
}
