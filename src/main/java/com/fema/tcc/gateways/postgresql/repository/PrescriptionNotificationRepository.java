package com.fema.tcc.gateways.postgresql.repository;

import com.fema.tcc.gateways.postgresql.entity.PrescriptionNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionNotificationRepository
    extends JpaRepository<PrescriptionNotificationEntity, Long> {}
