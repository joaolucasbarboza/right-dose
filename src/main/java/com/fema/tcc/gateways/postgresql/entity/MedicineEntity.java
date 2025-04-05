package com.fema.tcc.gateways.postgresql.entity;

import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.medicine.DosagePerUnit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

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

  @Embedded private DosagePerUnit dosagePerUnit;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @NotNull
  private UserEntity user;
}
