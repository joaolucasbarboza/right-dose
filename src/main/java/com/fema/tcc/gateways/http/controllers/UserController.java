package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.gateways.http.jsons.UserResponseJson;
import com.fema.tcc.gateways.http.mappers.UserJsonMapper;
import com.fema.tcc.usecases.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class UserController {

  private final UserUseCase userUseCase;
  private final UserJsonMapper userJsonMapper;

  @GetMapping
  public ResponseEntity<UserResponseJson> getById() {

    UserResponseJson response = userJsonMapper.domainToResponse(userUseCase.getUser());

    return ResponseEntity.ok().body(response);
  }
}
