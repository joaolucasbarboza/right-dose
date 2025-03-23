package com.fema.tcc.gateways.impl;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.UserGateway;
import com.fema.tcc.gateways.http.mappers.AuthJsonMapper;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import com.fema.tcc.gateways.postgresql.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayImpl implements UserGateway {

  private final UserRepository userRepository;
  private final AuthJsonMapper authJsonMapper;

  public UserGatewayImpl(UserRepository userRepository, AuthJsonMapper authJsonMapper) {
    this.userRepository = userRepository;
    this.authJsonMapper = authJsonMapper;
  }

  @Override
  public User save(User user) {
    UserEntity entity = authJsonMapper.entityToDomain(user);
    userRepository.save(entity);
    return authJsonMapper.entityToDomain(entity);
  }

  @Override
  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }
}
