package com.fema.tcc.gateways.http.json;

import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.medicine.DosagePerUnit;
import jakarta.validation.constraints.NotNull;

public record MedicineRequestJson(
    @NotNull String name,
    String description,
    @NotNull int quantity,
    @NotNull MedicineUnit unit,
    @NotNull DosagePerUnit dosagePerUnit) {}
