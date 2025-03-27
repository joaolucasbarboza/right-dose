package com.fema.tcc.gateways.postgresql.entity;

import com.fema.tcc.domains.enums.MedicineUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "medicine")
@Table(name = "medicine")
public class MedicineEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "medicine_id")
  private Integer medicineId;

  @NotNull private String name;

  private String description;

  @NotNull private int quantity;

  @NotNull
  @Enumerated(EnumType.STRING)
  private MedicineUnit unit;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable = false)
  private Date createdAt = new Date();

  @ManyToOne
  @JoinColumn(name = "user_id")
  @NotNull
  private UserEntity user;

  public MedicineEntity(
      String name, String description, int quantity, MedicineUnit unit, UserEntity user) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.unit = unit;
    this.user = user;
  }
}
