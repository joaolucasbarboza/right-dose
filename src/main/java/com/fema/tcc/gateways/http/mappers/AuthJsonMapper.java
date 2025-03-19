package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.json.LoginRequestJson;
import org.springframework.stereotype.Component;

@Component
public class AuthJsonMapper {

  public User convertLoginRequestToDomain(LoginRequestJson loginRequestJson) {
    return new User(loginRequestJson.email(), loginRequestJson.password());
  }
}
