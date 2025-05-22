package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.prescription.Prescription;
import com.fema.tcc.domains.prescriptionNotification.PrescriptionNotification;
import com.fema.tcc.gateways.postgresql.entity.PrescriptionEntity;
import com.fema.tcc.gateways.postgresql.entity.PrescriptionNotificationEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PrescriptionNotificationJsonMapper {

  private final PrescriptionJsonMapper prescriptionJsonMapper;

  public PrescriptionNotificationEntity domainToEntity(
      PrescriptionNotification prescriptionNotification) {
    PrescriptionEntity prescriptionEntity =
        prescriptionJsonMapper.domainToEntity(prescriptionNotification.getPrescription());

    return new PrescriptionNotificationEntity(
        prescriptionNotification.getId(),
        prescriptionEntity,
        prescriptionNotification.getNotificationTime(),
        prescriptionNotification.getStatus(),
        prescriptionNotification.getCreatedAt(),
        prescriptionNotification.getUpdatedAt());
  }

  public PrescriptionNotification entityToDomain(PrescriptionNotificationEntity entity) {
    Prescription prescriptionDomain =
        prescriptionJsonMapper.entityToDomain(entity.getPrescription());

    return new PrescriptionNotification(
        entity.getNotificationId(),
        prescriptionDomain,
        entity.getNotificationTime(),
        entity.getStatus(),
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }
}
