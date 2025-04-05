package com.fema.tcc.usecases.prescription;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.prescription.Prescription;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.MedicineGateway;
import com.fema.tcc.gateways.PrescriptionGateway;
import com.fema.tcc.gateways.http.exceptions.NotFoundException;
import com.fema.tcc.usecases.user.UserUseCase;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionUseCase {

  private final PrescriptionGateway prescriptionGateway;
  private final UserUseCase userUseCase;
  private final MedicineGateway medicineGateway;

  public Prescription create(Prescription request) {
    User user = userUseCase.getUser();

    return medicineGateway
        .findById(request.getMedicine().getId())
        .map(
            medicine -> {
              if (!medicine.getUser().getUserId().equals(user.getUserId())) {
                throw new SecurityException("User is not authorized to perform this action");
              }

              return Prescription.builder()
                  .medicine(medicine)
                  .user(medicine.getUser())
                  .dosageAmount(request.getDosageAmount())
                  .dosageUnit(request.getDosageUnit())
                  .frequency(request.getFrequency())
                  .uomFrequency(request.getUomFrequency())
                  .totalDays(request.getTotalDays())
                  .startDate(request.getStartDate())
                  .endDate(request.getEndDate())
                  .instructions(request.getInstructions())
                  .createdAt(LocalDateTime.now())
                  .build();
            })
        .map(prescriptionGateway::save)
        .orElseThrow(() -> new NotFoundException("Medicine not found"));
  }

  public List<Prescription> getAll() {
    return prescriptionGateway.findAll();
  }

  public Prescription update(Long id, Prescription updatedPrescription) {
    User user = userUseCase.getUser();

    return prescriptionGateway
        .findById(id)
        .map(
            prescription -> {
              if (!prescription.getUser().getUserId().equals(user.getUserId())) {
                throw new SecurityException("User is not authorized to perform this action");
              }

              if (prescription
                  .getMedicine()
                  .getId()
                  .equals(updatedPrescription.getMedicine().getId())) {
                throw new SecurityException("Medicine already registered");
              }

              Medicine medicine =
                  medicineGateway
                      .findById(updatedPrescription.getMedicine().getId())
                      .map(
                          foundMedicine -> {
                            if (!foundMedicine.getUser().getUserId().equals(user.getUserId())) {
                              throw new SecurityException(
                                  "User is not authorized to perform this action");
                            }
                            return foundMedicine;
                          })
                      .orElseThrow(() -> new NotFoundException("Medicine not found"));

              prescription.setMedicine(medicine);
              prescription.updateFrom(updatedPrescription);
              return prescription;
            })
        .map(prescriptionGateway::save)
        .orElseThrow(() -> new NotFoundException("Prescription not found"));
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
