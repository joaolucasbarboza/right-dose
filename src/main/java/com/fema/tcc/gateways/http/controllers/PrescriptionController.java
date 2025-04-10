package com.fema.tcc.gateways.http.controllers;

import com.fema.tcc.domains.prescription.Prescription;
import com.fema.tcc.gateways.http.jsons.PrescriptionRequestJson;
import com.fema.tcc.gateways.http.jsons.PrescriptionResponseJson;
import com.fema.tcc.gateways.http.mappers.PrescriptionJsonMapper;
import com.fema.tcc.usecases.prescription.PrescriptionUseCase;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "prescription")
@AllArgsConstructor
public class PrescriptionController {

  private final PrescriptionUseCase prescriptionUseCase;
  private final PrescriptionJsonMapper prescriptionJsonMapper;

  @PostMapping
  public ResponseEntity<PrescriptionResponseJson> create(
      @RequestBody PrescriptionRequestJson requestJson) {

    Prescription prescription =
        prescriptionUseCase.create(prescriptionJsonMapper.requestToDomain(requestJson));
    PrescriptionResponseJson responseJson = prescriptionJsonMapper.domainToResponse(prescription);

    return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
  }

  @GetMapping
  public ResponseEntity<List<PrescriptionResponseJson>> findAll() {

    List<Prescription> prescriptions = prescriptionUseCase.getAll();
    List<PrescriptionResponseJson> responseJson =
        prescriptions.stream().map(prescriptionJsonMapper::domainToResponse).toList();

    return ResponseEntity.status(HttpStatus.OK).body(responseJson);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PrescriptionResponseJson> findById(@PathVariable Long id) {

    Prescription prescription = prescriptionUseCase.getById(id);
    PrescriptionResponseJson responseJson = prescriptionJsonMapper.domainToResponse(prescription);

    return ResponseEntity.status(HttpStatus.OK).body(responseJson);
  }

  @PutMapping
  public ResponseEntity<PrescriptionResponseJson> update(
      @RequestParam Long id, @RequestBody @Valid PrescriptionRequestJson requestJson) {

    Prescription prescription =
        prescriptionUseCase.update(id, prescriptionJsonMapper.requestToDomain(requestJson));
    PrescriptionResponseJson responseJson = prescriptionJsonMapper.domainToResponse(prescription);

    return ResponseEntity.status(HttpStatus.OK).body(responseJson);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {

    prescriptionUseCase.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
