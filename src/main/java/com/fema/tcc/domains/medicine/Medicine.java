package com.fema.tcc.domains.medicine;

import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.user.User;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Medicine {
  private Integer id;
  private String name;
  private String description;
  private int quantity;
  private MedicineUnit unit;
  private DosagePerUnit dosagePerUnit;
  private Date createdAt;
  private Date updatedAt;
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
    this.createdAt = new Date();
    this.updatedAt = new Date();
  }

  public Medicine(
      Integer id,
      String name,
      String description,
      int quantity,
      MedicineUnit unit,
      DosagePerUnit dosagePerUnit,
      User user,
      Date createdAt,
      Date updatedAt) {
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
