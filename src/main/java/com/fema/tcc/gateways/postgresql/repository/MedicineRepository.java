package com.fema.tcc.gateways.postgresql.repository;

import com.fema.tcc.gateways.postgresql.entity.MedicineEntity;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Integer> {
  List<MedicineEntity> findByUser(UserEntity user);
}
