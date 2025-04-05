package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.jsons.MedicineRequestJson;
import com.fema.tcc.gateways.http.jsons.MedicineResponseJson;
import com.fema.tcc.gateways.postgresql.entity.MedicineEntity;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MedicineJsonMapper {

  private final UserJsonMapper userJsonMapper;

  public Medicine requestToDomain(MedicineRequestJson medicineRequestJson) {
    return new Medicine(
        medicineRequestJson.name(),
        medicineRequestJson.description(),
        medicineRequestJson.quantity(),
        medicineRequestJson.unit(),
        medicineRequestJson.dosagePerUnit());
  }

  public MedicineEntity domainToEntity(Medicine medicine) {
    UserEntity userEntity = userJsonMapper.domainToEntity(medicine.getUser());

    return new MedicineEntity(
        medicine.getId(),
        medicine.getName(),
        medicine.getDescription(),
        medicine.getQuantity(),
        medicine.getUnit(),
        medicine.getDosagePerUnit(),
        medicine.getCreatedAt(),
        medicine.getUpdatedAt(),
        userEntity);
  }

  public MedicineResponseJson domainToResponse(Medicine medicine) {
    return new MedicineResponseJson(
        medicine.getId(),
        medicine.getName(),
        medicine.getDescription(),
        medicine.getQuantity(),
        medicine.getUnit(),
        medicine.getDosagePerUnit(),
        medicine.getCreatedAt(),
        medicine.getUpdatedAt());
  }

  public List<MedicineResponseJson> domainListToResponseList(List<Medicine> medicineList) {
    return medicineList.stream().map(this::domainToResponse).collect(Collectors.toList());
  }

  public Medicine entityToDomain(MedicineEntity entity) {
    User user = userJsonMapper.entityToDomain(entity.getUser());

    return new Medicine(
        entity.getMedicineId(),
        entity.getName(),
        entity.getDescription(),
        entity.getQuantity(),
        entity.getUnit(),
        entity.getDosagePerUnit(),
        user,
        entity.getCreatedAt(),
        entity.getUpdatedAt());
  }
}
