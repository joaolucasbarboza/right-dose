package com.fema.tcc.gateways.http.mappers;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.http.jsons.LoginRequestJson;
import com.fema.tcc.gateways.http.jsons.LoginResponseJson;
import com.fema.tcc.gateways.http.jsons.RegisterRequestJson;
import com.fema.tcc.gateways.http.jsons.RegisterResponseJson;
import java.util.ArrayList;
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
        registerRequestJson.getRole(),
        new ArrayList<>());
  }

  public RegisterResponseJson domainToRegisterResponse(User user) {
    return new RegisterResponseJson(
        user.getUserId(), user.getName(), user.getEmail(), user.getRole(), user.getCreateAt());
  }
}
