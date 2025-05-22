package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.prescription.Prescription;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.jsons.MedicineResponseJson;
import com.fema.tcc.gateways.http.jsons.PrescriptionRequestJson;
import com.fema.tcc.gateways.http.jsons.PrescriptionResponseJson;
import com.fema.tcc.gateways.postgresql.entity.MedicineEntity;
import com.fema.tcc.gateways.postgresql.entity.PrescriptionEntity;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrescriptionJsonMapper {

  private final MedicineJsonMapper medicineJsonMapper;
  private final UserJsonMapper userJsonMapper;

  public PrescriptionEntity domainToEntity(Prescription prescription) {
    MedicineEntity medicineEntity = medicineJsonMapper.domainToEntity(prescription.getMedicine());
    UserEntity userEntity = userJsonMapper.domainToEntity(prescription.getUser());

    return new PrescriptionEntity(
        prescription.getPrescriptionId(),
        medicineEntity,
        userEntity,
        prescription.getDosageAmount(),
        prescription.getDosageUnit(),
        prescription.getFrequency(),
        prescription.getUomFrequency(),
        prescription.getTotalDays(),
        prescription.getStartDate(),
        prescription.getEndDate(),
        prescription.isWantsNotifications(),
        prescription.getInstructions(),
        prescription.getCreatedAt(),
        prescription.getUpdatedAt());
  }

  public Prescription entityToDomain(PrescriptionEntity prescriptionEntity) {
    Medicine medicine = medicineJsonMapper.entityToDomain(prescriptionEntity.getMedicine());
    User user = userJsonMapper.entityToDomain(prescriptionEntity.getUser());

    return new Prescription(
        prescriptionEntity.getPrescriptionId(),
        medicine,
        user,
        prescriptionEntity.getDosageAmount(),
        prescriptionEntity.getDosageUnit(),
        prescriptionEntity.getFrequency(),
        prescriptionEntity.getUomFrequency(),
        prescriptionEntity.getTotalDays(),
        prescriptionEntity.getStartDate(),
        prescriptionEntity.getEndDate(),
        prescriptionEntity.isWantsNotifications(),
        prescriptionEntity.getInstructions(),
        prescriptionEntity.getCreatedAt(),
        prescriptionEntity.getUpdatedAt());
  }

  public Prescription requestToDomain(PrescriptionRequestJson request) {
    Medicine medicine = new Medicine();
    medicine.setId(request.medicineId());

    return new Prescription(
        null,
        medicine,
        null,
        request.dosageAmount(),
        request.dosageUnit(),
        request.frequency(),
        request.uomFrequency(),
        request.totalDays(),
        request.startDate(),
        null,
        request.wantsNotifications(),
        request.instructions(),
        null,
        null);
  }

  public PrescriptionResponseJson domainToResponse(Prescription prescription) {
    MedicineResponseJson medicineResponseJson =
        medicineJsonMapper.domainToResponse(prescription.getMedicine());

    return new PrescriptionResponseJson(
        prescription.getPrescriptionId(),
        medicineResponseJson,
        prescription.getDosageAmount(),
        prescription.getDosageUnit(),
        prescription.getFrequency(),
        prescription.getUomFrequency(),
        prescription.getTotalDays(),
        prescription.getStartDate(),
        prescription.getEndDate(),
        prescription.isWantsNotifications(),
        prescription.getInstructions(),
        prescription.getCreatedAt(),
        prescription.getUpdatedAt());
  }
}
