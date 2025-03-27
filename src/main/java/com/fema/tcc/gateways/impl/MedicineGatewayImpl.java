package com.fema.tcc.gateways.impl;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.MedicineGateway;
import com.fema.tcc.gateways.http.mappers.MedicineJsonMapper;
import com.fema.tcc.gateways.http.mappers.UserJsonMapper;
import com.fema.tcc.gateways.postgresql.entity.MedicineEntity;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import com.fema.tcc.gateways.postgresql.repository.MedicineRepository;
import com.fema.tcc.gateways.postgresql.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicineGatewayImpl implements MedicineGateway {

  private final MedicineRepository medicineRepository;
  private final MedicineJsonMapper medicineJsonMapper;
  private final UserRepository userRepository;
  private final UserJsonMapper userJsonMapper;

  @Override
  public Medicine save(Integer userId, Medicine medicine) {
    UserEntity userEntity =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

    User user = userJsonMapper.entityToDomain(userEntity);

    MedicineEntity medicineEntity = medicineJsonMapper.domainToEntity(user, medicine);
    medicineRepository.save(medicineEntity);

    return medicineJsonMapper.entityToDomain(medicineEntity);
  }

  @Override
  public List<Medicine> findMedicinesByUserId(User user) {

    UserEntity userEntity = userJsonMapper.domainToEntity(user);
    List<MedicineEntity> medicineEntities = medicineRepository.findByUser(userEntity);

    return medicineEntities.stream()
        .map(medicineJsonMapper::entityToDomain)
        .collect(Collectors.toList());
  }
}
