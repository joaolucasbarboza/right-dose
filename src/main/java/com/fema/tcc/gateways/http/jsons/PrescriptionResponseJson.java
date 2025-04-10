package com.fema.tcc.gateways.http.jsons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fema.tcc.domains.enums.DosageUnit;
import com.fema.tcc.domains.enums.Frequency;
import java.time.LocalDateTime;
import java.util.Date;

public record PrescriptionResponseJson(
    Long id,
    MedicineResponseJson medicine,
    double dosageAmount,
    DosageUnit dosageUnit,
    int frequency,
    Frequency uomfrequency,
    int totalDays,
    Date startDate,
    Date endDate,
    String instructions,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC") LocalDateTime createdAt,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC") LocalDateTime updatedAt) {}
