package com.ifba.smart.api.domain.model;

import java.time.LocalDateTime;

public class SensorData {
  private Integer id;
  private Float data;
  private LocalDateTime timestamp;

  public SensorData() {
    this.timestamp = LocalDateTime.now();
  }

  public SensorData(Float data) {
    this.timestamp = LocalDateTime.now();
    this.data = data;
  }

  public SensorData(Integer id, Float data, LocalDateTime timestamp) {
    this.id = id;
    this.data = data;
    this.timestamp = timestamp;
  } 

  public Integer getId() {
    return id;
  }

  public Float getData() {
    return data;
  }

  public void setData(Float data) {
    this.data = data;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
