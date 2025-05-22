package com.fema.tcc.gateways.http.jsons;

import java.time.LocalDateTime;

public record PrescriptionNotificationResquestJson(
    Long id, Long prescriptionId, LocalDateTime notification) {}
