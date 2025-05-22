package com.fema.tcc.usecases.prescriptionNotification.steps;

import com.fema.tcc.domains.enums.Frequency;
import com.fema.tcc.domains.prescription.Prescription;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenerateNotificationTimes {

  public List<LocalDateTime> execute(Prescription prescription, LocalDateTime end) {
    List<LocalDateTime> times = new ArrayList<>();

    LocalDateTime current = prescription.getStartDate();
    Duration interval = getInterval(prescription);

    while (!current.isAfter(end)) {
      times.add(current);
      current = current.plus(interval);
    }

    return times;
  }

  private Duration getInterval(Prescription prescription) {
    Frequency freq = prescription.getUomFrequency();
    int value = prescription.getFrequency();

    if (freq.equals(Frequency.HOURLY)) {
      return Duration.ofHours(value);
    } else if (freq.equals(Frequency.DAILY)) {
      return Duration.ofDays(value);
    } else {
      throw new IllegalArgumentException("Unsupported frequency: " + freq);
    }
  }
}
