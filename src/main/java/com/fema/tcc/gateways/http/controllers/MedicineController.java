package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.gateways.http.json.MedicineRequest;
import com.fema.tcc.gateways.http.json.MedicineResponseJson;
import com.fema.tcc.gateways.http.mappers.MedicineJsonMapper;
import com.fema.tcc.usecases.Medicine.MedicineUseCase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "medicine")
public class MedicineController {

  private final MedicineUseCase medicineUseCase;
  private final MedicineJsonMapper medicineJsonMapper;

  @Autowired
  public MedicineController(
      MedicineUseCase medicineUseCase, MedicineJsonMapper medicineJsonMapper) {
    this.medicineUseCase = medicineUseCase;
    this.medicineJsonMapper = medicineJsonMapper;
  }

  @PostMapping
  public ResponseEntity<MedicineResponseJson> create(@RequestBody MedicineRequest medicineRequest) {

    Medicine medicine = medicineUseCase.create(medicineJsonMapper.requestToDomain(medicineRequest));
    MedicineResponseJson responseJson = medicineJsonMapper.domainToResponse(medicine);

    return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
  }

  @GetMapping
  public ResponseEntity<List<MedicineResponseJson>> getMedicine() {

    List<MedicineResponseJson> medicineResponseList =
        medicineJsonMapper.domainListToResponseList(medicineUseCase.getMedicines());

    return ResponseEntity.status(HttpStatus.OK).body(medicineResponseList);
  }
}
