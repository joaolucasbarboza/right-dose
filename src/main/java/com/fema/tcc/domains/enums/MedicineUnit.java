package com.fema.tcc.domains.enums;

import lombok.Getter;

@Getter
public enum MedicineUnit {
  MILLIGRAM("mg"),
  MICROGRAM("mcg"),
  GRAM("g"),
  KILOGRAM("kg"),
  MILLILITER("ml"),
  LITER("L"),
  UNIT("UI"),
  DROP("gotas"),
  TABLET("comprimido"),
  CAPSULE("cápsula"),
  TEASPOON("colher de chá"),
  TABLESPOON("colher de sopa"),
  INHALATION("inalação"),
  PATCH("adesivo"),
  PUFF("puff"),
  DOSE("dose");

  private final String unit;

  MedicineUnit(String unit) {
    this.unit = unit;
  }
}
