package com.fema.tcc.domains.enums;

import lombok.Getter;

@Getter
public enum Status {
  PENDING("pending"),
  SEND("send"),
  CONFIRMED("confirmed");

  private final String value;

  Status(String value) {
    this.value = value;
  }
}
