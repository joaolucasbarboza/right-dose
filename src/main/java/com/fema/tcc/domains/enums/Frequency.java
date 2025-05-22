package com.fema.tcc.domains.enums;

import lombok.Getter;

@Getter
public enum Frequency {
  HOURLY("hourly"),
  DAILY("daily"),
  ;

  private final String value;

  Frequency(String value) {
    this.value = value;
  }
}
