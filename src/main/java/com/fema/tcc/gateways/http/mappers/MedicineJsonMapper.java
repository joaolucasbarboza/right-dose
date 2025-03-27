package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.json.MedicineRequest;
import com.fema.tcc.gateways.http.json.MedicineResponseJson;
import com.fema.tcc.gateways.postgresql.entity.MedicineEntity;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MedicineJsonMapper {

  public Medicine requestToDomain(MedicineRequest medicineRequest) {
    return new Medicine(
        medicineRequest.name(),
        medicineRequest.description(),
        medicineRequest.quantity(),
        medicineRequest.unit());
  }

  public MedicineEntity domainToEntity(User user, Medicine medicine) {
    return new MedicineEntity(
        medicine.getName(),
        medicine.getDescription(),
        medicine.getQuantity(),
        medicine.getUnit(),
        new UserEntity(user.getUserId()));
  }

  public MedicineResponseJson domainToResponse(Medicine medicine) {
    return new MedicineResponseJson(
        medicine.getId(),
        medicine.getName(),
        medicine.getDescription(),
        medicine.getQuantity(),
        medicine.getUnit(),
        medicine.getCreatedAt());
  }

  public List<MedicineResponseJson> domainListToResponseList(List<Medicine> medicineList) {
    return medicineList.stream().map(this::domainToResponse).collect(Collectors.toList());
  }

  public Medicine entityToDomain(MedicineEntity entity) {
    return new Medicine(
        entity.getMedicineId(),
        entity.getName(),
        entity.getDescription(),
        entity.getQuantity(),
        entity.getUnit(),
        entity.getCreatedAt(),
        entity.getUser() != null ? new User(entity.getUser().getUserId()) : null);
  }
}
