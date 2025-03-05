package com.ifba.smart.api.solo.infra.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.solo.domain.SoloSensorService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/solo")
public class SoloRestController {

  private final SoloSensorService soloSensorService;

  public SoloRestController(SoloSensorService soloSensorService) {
      this.soloSensorService = soloSensorService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<SensorData>> getAllData() {
    var data = soloSensorService.getAll();
    return ResponseEntity.ok(data);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteData(@PathVariable Integer id) {
    soloSensorService.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}
