package com.fema.tcc.usecases.prescription;

import com.fema.tcc.domains.prescription.Prescription;
import com.fema.tcc.gateways.PrescriptionGateway;
import com.fema.tcc.gateways.http.exceptions.NotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionUseCase {

  private final PrescriptionGateway prescriptionGateway;

  public List<Prescription> getAll() {
    return prescriptionGateway.findAll();
  }

  public Prescription getById(Long id) {

    return prescriptionGateway
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Prescription not found"));
  }

  public void deleteById(Long id) {

    prescriptionGateway
        .findById(id)
        .ifPresentOrElse(
            prescription -> prescriptionGateway.deleteById(id),
            () -> {
              throw new NotFoundException("Prescription not found");
            });
  }
}
