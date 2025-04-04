package com.fema.tcc.domains.medicine;

import com.fema.tcc.domains.enums.DosageUnit;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DosagePerUnit {

  private double dosageAmount;

  @Enumerated(EnumType.STRING)
  private DosageUnit dosageUnit;
}
