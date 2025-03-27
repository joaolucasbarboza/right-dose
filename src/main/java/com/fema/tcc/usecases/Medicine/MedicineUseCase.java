package com.fema.tcc.usecases.Medicine;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.MedicineGateway;
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

    Integer userId = userUseCase.getCurrentUser();
    return medicineGateway.save(userId, medicine);
  }

  public List<Medicine> getMedicines() {

    User user = userUseCase.getUser();
    return medicineGateway.findMedicinesByUserId(user);
  }
}
