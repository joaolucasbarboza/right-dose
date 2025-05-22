package com.fema.tcc.gateways;

import com.fema.tcc.domains.prescriptionNotification.PrescriptionNotification;
import java.util.List;

public interface PrescriptionNotificationGateway {

  void saveAll(List<PrescriptionNotification> prescriptions);
}
