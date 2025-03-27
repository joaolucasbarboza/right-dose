package com.fema.tcc.gateways;

import com.fema.tcc.domains.medicine.Medicine;
import com.fema.tcc.domains.user.User;
import java.util.List;

public interface MedicineGateway {

  Medicine save(Integer userId, Medicine medicine);

  List<Medicine> findMedicinesByUserId(User user);
}
