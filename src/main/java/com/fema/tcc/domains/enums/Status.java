package com.fema.tcc.domains.enums;

import lombok.Getter;

@Getter
public enum Status {
  PENDING("pending"),
  SENT("sent"),
  CONFIRMED("confirmed");

  private final String value;

  Status(String value) {
    this.value = value;
  }
}
