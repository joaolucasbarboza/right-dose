package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.json.LoginRequestJson;
import com.fema.tcc.gateways.http.json.LoginResponseJson;
import com.fema.tcc.gateways.http.json.RegisterRequestJson;
import com.fema.tcc.gateways.http.json.RegisterResponseJson;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthJsonMapper {

  public User loginRequestToDomain(LoginRequestJson loginRequestJson) {
    return new User(loginRequestJson.email(), loginRequestJson.password());
  }

  public LoginResponseJson toLoginResponseJson(String token) {
    return new LoginResponseJson(token);
  }

  public User registerRequestToDomain(RegisterRequestJson registerRequestJson) {
    return new User(
        registerRequestJson.getName(),
        registerRequestJson.getEmail(),
        registerRequestJson.getPassword(),
        registerRequestJson.getRole());
  }

  public RegisterResponseJson domainToRegisterResponse(User user) {
    return new RegisterResponseJson(
        user.getUserId(), user.getName(), user.getEmail(), user.getRole(), user.getCreateAt());
  }

  public UserEntity entityToDomain(User domain) {
    return new UserEntity(
        domain.getName(), domain.getEmail(), domain.getPassword(), domain.getRole());
  }

  public User entityToDomain(UserEntity entity) {
    return new User(
        entity.getUserId(),
        entity.getName(),
        entity.getEmail(),
        entity.getCreatedAt(),
        entity.getRole());
  }
}
