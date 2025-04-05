package com.fema.tcc.domains.medicine;

import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.user.User;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
  private Integer id;
  private String name;
  private String description;
  private int quantity;
  private MedicineUnit unit;
  private DosagePerUnit dosagePerUnit;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private User user;

  public Medicine(
      String name,
      String description,
      int quantity,
      MedicineUnit unit,
      DosagePerUnit dosagePerUnit) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.unit = unit;
    this.dosagePerUnit = dosagePerUnit;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public Medicine(
      Integer id,
      String name,
      String description,
      int quantity,
      MedicineUnit unit,
      DosagePerUnit dosagePerUnit,
      User user,
      LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.unit = unit;
    this.dosagePerUnit = dosagePerUnit;
    this.user = user;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}
