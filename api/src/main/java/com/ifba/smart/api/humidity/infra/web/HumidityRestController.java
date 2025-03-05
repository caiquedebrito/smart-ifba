package com.ifba.smart.api.humidity.infra.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.humidity.domain.HumiditySensorService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/humidity")
public class HumidityRestController {

  private final HumiditySensorService humiditySensorService;

  public HumidityRestController(HumiditySensorService humiditySensorService) {
      this.humiditySensorService = humiditySensorService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<SensorData>> getAllData() {
    var data = humiditySensorService.getAll();
    return ResponseEntity.ok(data);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteData(@PathVariable Integer id) {
    humiditySensorService.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}
