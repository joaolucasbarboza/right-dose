package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.gateways.http.json.LoginRequestJson;
import com.fema.tcc.gateways.http.json.LoginResponseJson;
import com.fema.tcc.gateways.http.json.RegisterRequestJson;
import com.fema.tcc.gateways.http.mappers.AuthJsonMapper;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import com.fema.tcc.gateways.postgresql.repository.UserRepository;
import com.fema.tcc.usecases.AuthUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

  private final UserRepository userRepository;
  private final AuthUseCase authUseCase;
  private final AuthJsonMapper authJsonMapper;

  @Autowired
  public AuthenticationController(UserRepository userRepository, AuthUseCase authUseCase, AuthJsonMapper authJsonMapper) {
    this.userRepository = userRepository;
      this.authUseCase = authUseCase;
      this.authJsonMapper = authJsonMapper;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponseJson> login(
      @RequestBody @Valid LoginRequestJson loginRequestJson) {

    String token =
        authUseCase.execute(authJsonMapper.convertLoginRequestToDomain(loginRequestJson));

    return ResponseEntity.ok(new LoginResponseJson(token));
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid RegisterRequestJson registerRequestJson) {
    if (this.userRepository.findByEmail(registerRequestJson.getEmail()) != null) {
      return ResponseEntity.badRequest().build();
    }

    String encryptedPassword =
        new BCryptPasswordEncoder().encode(registerRequestJson.getPassword());
    UserEntity userEntity =
        new UserEntity(
            registerRequestJson.getEmail(), encryptedPassword, registerRequestJson.getRole());

    this.userRepository.save(userEntity);
    return ResponseEntity.ok().build();
  }
}
