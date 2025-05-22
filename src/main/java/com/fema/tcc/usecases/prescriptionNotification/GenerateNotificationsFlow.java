package com.fema.tcc.usecases.prescriptionNotification;

import com.fema.tcc.domains.prescription.Prescription;
import com.fema.tcc.domains.prescriptionNotification.PrescriptionNotification;
import com.fema.tcc.gateways.PrescriptionNotificationGateway;
import com.fema.tcc.usecases.prescriptionNotification.steps.BuildNotifications;
import com.fema.tcc.usecases.prescriptionNotification.steps.GenerateNotificationTimes;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenerateNotificationsFlow {

  private final GenerateNotificationTimes generateNotificationTimes;
  private final BuildNotifications buildNotifications;
  private final PrescriptionNotificationGateway gateway;

  public void execute(Prescription prescription) {

    List<LocalDateTime> notificationTimes =
        generateNotificationTimes.execute(prescription, prescription.getEndDate());

    List<PrescriptionNotification> notifications =
        buildNotifications.execute(prescription, notificationTimes);

    gateway.saveAll(notifications);
  }
}
