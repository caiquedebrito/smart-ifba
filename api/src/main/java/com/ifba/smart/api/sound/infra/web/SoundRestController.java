package com.ifba.smart.api.sound.infra.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.smart.api.domain.model.SensorData;
import com.ifba.smart.api.sound.domain.SoundSensorService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/sound")
public class SoundRestController {

  private final SoundSensorService soundSensorService;

  public SoundRestController(SoundSensorService soundSensorService) {
      this.soundSensorService = soundSensorService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<SensorData>> getAllData() {
    var data = soundSensorService.getAll();
    return ResponseEntity.ok(data);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteData(@PathVariable Integer id) {
    soundSensorService.delete(id);
    return ResponseEntity.noContent().build();
  }
  
}
