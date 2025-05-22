package com.fema.tcc.domains.prescription;

import com.fema.tcc.domains.enums.DosageUnit;
import com.fema.tcc.domains.enums.Frequency;
import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prescription {

  private Long prescriptionId;
  private Medicine medicine;
  private User user;
  private double dosageAmount;
  private DosageUnit dosageUnit;
  private int frequency;
  private Frequency uomFrequency;
  private int totalDays;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private boolean wantsNotifications;
  private String instructions;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public void updateFrom(Prescription source) {
    this.setDosageAmount(source.getDosageAmount());
    this.setDosageUnit(source.getDosageUnit());
    this.setFrequency(source.getFrequency());
    this.setUomFrequency(source.getUomFrequency());
    this.setTotalDays(source.getTotalDays());
    this.setStartDate(source.getStartDate());
    this.setEndDate(source.getEndDate());
    this.setInstructions(source.getInstructions());
  }
}
