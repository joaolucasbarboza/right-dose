package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.gateways.http.json.LoginRequestJson;
import com.fema.tcc.gateways.http.json.LoginResponseJson;
import com.fema.tcc.gateways.http.json.RegisterRequestJson;
import com.fema.tcc.gateways.http.json.RegisterResponseJson;
import com.fema.tcc.gateways.http.mappers.AuthJsonMapper;
import com.fema.tcc.usecases.Auth.AuthUseCase;
import com.fema.tcc.usecases.Auth.RegisterUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    value = "auth",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

  private final AuthUseCase authUseCase;
  private final AuthJsonMapper authJsonMapper;
  private final RegisterUseCase registerUseCase;

  @Autowired
  public AuthenticationController(
      AuthUseCase authUseCase, AuthJsonMapper authJsonMapper, RegisterUseCase registerUseCase) {
    this.authUseCase = authUseCase;
    this.authJsonMapper = authJsonMapper;
    this.registerUseCase = registerUseCase;
  }

  @PostMapping(value = "/login")
  public ResponseEntity<LoginResponseJson> login(
      @RequestBody @Valid LoginRequestJson loginRequestJson) {

    LoginResponseJson loginResponseJson =
        authJsonMapper.toLoginResponseJson(
            authUseCase.execute(authJsonMapper.loginRequestToDomain(loginRequestJson)));

    return ResponseEntity.ok().body(loginResponseJson);
  }

  @PostMapping(value = "/register")
  public ResponseEntity<RegisterResponseJson> register(
      @RequestBody @Valid RegisterRequestJson registerRequestJson) {

    RegisterResponseJson registerResponseJson =
        authJsonMapper.domainToRegisterResponse(
            registerUseCase.execute(authJsonMapper.registerRequestToDomain(registerRequestJson)));

    return ResponseEntity.status(HttpStatus.CREATED).body(registerResponseJson);
  }
}
