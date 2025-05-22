package com.fema.tcc.domains.prescriptionNotification;

import com.fema.tcc.domains.enums.Status;
import com.fema.tcc.domains.prescription.Prescription;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class PrescriptionNotification {

  private Long id;
  private Prescription prescription;
  private LocalDateTime notificationTime;
  private Status status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
