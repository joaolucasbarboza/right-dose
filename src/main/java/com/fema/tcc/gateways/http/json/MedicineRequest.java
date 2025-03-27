package com.fema.tcc.gateways.http.json;

import com.fema.tcc.domains.enums.MedicineUnit;

public record MedicineRequest(String name, String description, int quantity, MedicineUnit unit) {}
