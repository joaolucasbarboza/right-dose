package com.fema.tcc.gateways.postgresql.repository;

import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  UserEntity findByUserId(Integer userId);

  UserDetails findByEmail(String email);

  boolean existsByEmail(String email);
}
