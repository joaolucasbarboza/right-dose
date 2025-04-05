package com.fema.tcc.gateways.impl;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.UserGateway;
import com.fema.tcc.gateways.http.mappers.UserJsonMapper;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import com.fema.tcc.gateways.postgresql.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserGatewayImpl implements UserGateway {

  private final UserRepository userRepository;
  private final UserJsonMapper userJsonMapper;

  @Override
  public User findById(Integer userId) {
    return userJsonMapper.entityToDomain(userRepository.findByUserId(userId));
  }

  @Override
  public User save(User user) {
    UserEntity entity = userJsonMapper.domainToEntity(user);
    userRepository.save(entity);
    return userJsonMapper.entityToDomain(entity);
  }

  @Override
  public boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }
}
