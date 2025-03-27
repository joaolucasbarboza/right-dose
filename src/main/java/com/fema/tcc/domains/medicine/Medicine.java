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
  private Date createdAt;
  private User user;

  public Medicine(String name, String description, int quantity, MedicineUnit unit) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.unit = unit;
  }

  public Medicine(
      Integer id,
      String name,
      String description,
      int quantity,
      MedicineUnit unit,
      Date createdAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.unit = unit;
    this.createdAt = createdAt;
  }
}
