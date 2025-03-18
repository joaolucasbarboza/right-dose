package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.config.security.TokenService;
import com.fema.tcc.gateways.http.json.LoginRequestJson;
import com.fema.tcc.gateways.http.json.LoginResponseJson;
import com.fema.tcc.gateways.http.json.RegisterRequestJson;
import com.fema.tcc.gateways.postgresql.entity.UserEntity;
import com.fema.tcc.gateways.postgresql.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final TokenService tokenService;

  @Autowired
  public AuthenticationController(
      AuthenticationManager authenticationManager,
      UserRepository userRepository,
      TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
    this.tokenService = tokenService;
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid LoginRequestJson loginRequestJson) {
    var usernamePassword =
        new UsernamePasswordAuthenticationToken(
            loginRequestJson.email(), loginRequestJson.password());

    var authentication = this.authenticationManager.authenticate(usernamePassword);

    String token = tokenService.generateToken((UserEntity) authentication.getPrincipal());

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
