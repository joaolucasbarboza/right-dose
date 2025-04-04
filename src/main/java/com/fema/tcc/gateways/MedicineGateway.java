package com.fema.tcc.gateways;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import java.util.List;
import java.util.Optional;

public interface MedicineGateway {

  Medicine save(Medicine medicine);

  void deleteMedicine(Medicine medicine);

  List<Medicine> findMedicinesByUserId(User user);

  Optional<Medicine> findMedicineById(Integer medicineId);
}
