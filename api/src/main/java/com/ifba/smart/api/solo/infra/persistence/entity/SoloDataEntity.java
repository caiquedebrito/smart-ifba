package com.ifba.smart.api.solo.infra.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "solo_data")
public class SoloDataEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private Float data;
  private LocalDateTime timestamp;

  public SoloDataEntity() {}

  public SoloDataEntity(Float data, LocalDateTime timestamp) {
    this.data = data;
    this.timestamp = timestamp;
  }

  public Integer getId() {
    return id;
  }

  public Float getData() {
    return data;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
