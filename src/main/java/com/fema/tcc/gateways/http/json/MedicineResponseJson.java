package com.fema.tcc.gateways.http.json;

import com.fema.tcc.domains.enums.MedicineUnit;
import java.util.Date;

public record MedicineResponseJson(
    Integer id, String name, String description, int quantity, MedicineUnit unit, Date createdAt) {}
