package com.fema.tcc.gateways.http.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

  public MedicineController() {}

  @GetMapping
  public ResponseEntity<String> getAll() {
    return ResponseEntity.ok().body("Olá mundo!");
  }
}
