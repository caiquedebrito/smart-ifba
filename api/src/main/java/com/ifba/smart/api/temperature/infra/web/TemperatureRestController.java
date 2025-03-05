package com.ifba.smart.api.temperature.infra.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.temperature.domain.TemperatureSensorService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureRestController {

  private final TemperatureSensorService temperatureSensorService;

  public TemperatureRestController(TemperatureSensorService temperatureSensorService) {
      this.temperatureSensorService = temperatureSensorService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<SensorData>> getAllData() {
    var data = temperatureSensorService.getAll();
    return ResponseEntity.ok(data);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteData(@PathVariable Integer id) {
    temperatureSensorService.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}
