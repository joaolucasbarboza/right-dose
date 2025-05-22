package com.fema.tcc.usecases.prescriptionNotification;

import com.fema.tcc.domains.prescription.Prescription;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class CalculateEndDate {
  public LocalDateTime execute(Prescription prescription) {
    return prescription.getStartDate().plusDays(prescription.getTotalDays());
  }
}
