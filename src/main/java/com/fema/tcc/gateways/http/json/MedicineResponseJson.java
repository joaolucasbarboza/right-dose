package com.fema.tcc.gateways.http.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fema.tcc.domains.enums.MedicineUnit;
import com.fema.tcc.domains.medicine.DosagePerUnit;
import java.util.Date;

public record MedicineResponseJson(
    Integer id,
    String name,
    String description,
    int quantity,
    MedicineUnit unit,
    DosagePerUnit dosagePerUnit,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC") Date createdAt,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC") Date updatedAt) {}
