package com.fema.tcc.gateways;

import com.fema.tcc.domains.prescription.Prescription;
import java.util.List;
import java.util.Optional;

public interface PrescriptionGateway {

  Prescription save(Prescription prescription);

  List<Prescription> findAll();

  Optional<Prescription> findById(Long id);

  void deleteById(Long id);
}
