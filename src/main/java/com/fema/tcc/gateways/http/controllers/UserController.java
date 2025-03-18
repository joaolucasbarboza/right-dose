package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.gateways.postgresql.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserController {

  public UserController(UserRepository userRepository) {}
}
