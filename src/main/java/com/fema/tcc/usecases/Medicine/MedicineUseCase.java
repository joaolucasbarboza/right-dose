package com.fema.tcc.usecases.Medicine;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.MedicineGateway;
import com.fema.tcc.gateways.exceptions.NotFoundException;
import com.fema.tcc.usecases.User.UserUseCase;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicineUseCase {

  private final UserUseCase userUseCase;
  private final MedicineGateway medicineGateway;

  public Medicine create(Medicine medicine) {

    User user = userUseCase.getUser();
    medicine.setUser(user);
    return medicineGateway.save(medicine);
  }

  public List<Medicine> getMedicines() {
    User user = userUseCase.getUser();
    return medicineGateway.findMedicinesByUserId(user);
  }

  public Medicine getMedicineById(Integer id) {
    return medicineGateway
        .findMedicineById(id)
        .orElseThrow(() -> new NotFoundException("Medicine not found"));
  }

  public Medicine updateMedicine(Medicine medicineUpdate) {
    User user = userUseCase.getUser();

    Medicine medicine =
        medicineGateway
            .findMedicineById(medicineUpdate.getId())
            .orElseThrow(() -> new NotFoundException("Medicine not found"));

    if (!medicine.getUser().getUserId().equals(user.getUserId())) {
      throw new SecurityException("You do not have permission to update this medicine");
    }

    medicine.setName(medicineUpdate.getName());
    medicine.setDescription(medicineUpdate.getDescription());
    medicine.setQuantity(medicineUpdate.getQuantity());
    medicine.setUnit(medicineUpdate.getUnit());

    return medicineGateway.save(medicine);
  }

  public void deleteMedicine(Integer id) {
    medicineGateway
        .findMedicineById(id)
        .ifPresentOrElse(
            medicine -> {
              if (!medicine.getUser().getUserId().equals(userUseCase.getUser().getUserId())) {
                throw new SecurityException("You do not have permission to delete this medicine");
              }
              medicineGateway.deleteMedicine(medicine);
            },
            () -> {
              throw new NotFoundException("Medicine not found");
            });
  }
}
