package com.fema.tcc.gateways.http.jsons;

import com.fema.tcc.domains.enums.DosageUnit;
import com.fema.tcc.domains.enums.Frequency;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record PrescriptionRequestJson(
    @NotNull Integer medicineId,
    @NotNull double dosageAmount,
    @NotNull DosageUnit dosageUnit,
    @NotNull int frequency,
    @NotNull Frequency uomfrequency,
    @NotNull int totalDays,
    @NotNull Date startDate,
    @NotNull Date endDate,
    @NotNull String instructions) {}
