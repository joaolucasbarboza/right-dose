package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.json.UserResponseJson;
import com.fema.tcc.gateways.postgresql.entity.MedicineEntity;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserJsonMapper {

  public UserEntity domainToEntity(User domain) {
    return new UserEntity(
        domain.getUserId(),
        domain.getName(),
        domain.getEmail(),
        domain.getPassword(),
        domain.getCreateAt(),
        domain.getRole());
  }

  public User entityToDomain(UserEntity entity) {
    return new User(
        entity.getUserId(),
        entity.getName(),
        entity.getEmail(),
        entity.getRole(),
        entity.getMedicines() != null
            ? entity.getMedicines().stream()
                .map(this::medicineEntityToDomain)
                .collect(Collectors.toList())
            : new ArrayList<>());
  }

  private Medicine medicineEntityToDomain(MedicineEntity entity) {
    return new Medicine(
        entity.getMedicineId(),
        entity.getName(),
        entity.getDescription(),
        entity.getQuantity(),
        entity.getUnit(),
        entity.getCreatedAt());
  }

  public UserResponseJson domainToResponse(User user) {
    return new UserResponseJson(
        user.getUserId(), user.getName(), user.getEmail(), user.getCreateAt(), user.getRole());
  }
}
