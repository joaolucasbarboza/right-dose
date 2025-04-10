package com.fema.tcc.gateways.http.jsons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.medicine.DosagePerUnit;
import java.time.LocalDateTime;

public record MedicineResponseJson(
    Integer id,
    String name,
    String description,
    int quantity,
    MedicineUnit unit,
    DosagePerUnit dosagePerUnit,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC") LocalDateTime createdAt,
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC") LocalDateTime updatedAt) {}
