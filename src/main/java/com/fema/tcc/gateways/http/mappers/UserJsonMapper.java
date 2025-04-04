package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.json.UserResponseJson;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import java.util.ArrayList;
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
        new ArrayList<>());
  }

  public UserResponseJson domainToResponse(User user) {
    return new UserResponseJson(
        user.getUserId(), user.getName(), user.getEmail(), user.getCreateAt(), user.getRole());
  }
}
