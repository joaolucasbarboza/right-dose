package com.fema.tcc.gateways.http.jsons;

import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.medicine.DosagePerUnit;
import jakarta.validation.constraints.NotNull;

public record MedicineRequestJson(
    @NotNull(message = "medicine.name.blank") String name,
    String description,
    @NotNull(message = "medicine.quantity.blank") int quantity,
    @NotNull(message = "medicine.unit.blank") MedicineUnit unit,
    @NotNull(message = "medicine.dosagePerUnit.blank") DosagePerUnit dosagePerUnit) {}
