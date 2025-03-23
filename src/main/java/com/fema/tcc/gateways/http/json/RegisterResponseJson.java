package com.fema.tcc.gateways.http.json;

import com.fema.tcc.domains.enums.UserRole;
import java.util.Date;

public record RegisterResponseJson(
    Integer id, String name, String email, UserRole role, Date createdAt) {}
