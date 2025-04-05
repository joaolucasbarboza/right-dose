package com.fema.tcc.gateways.http.json;

import com.fema.tcc.domains.enums.UserRole;
import java.util.Date;

public record UserResponseJson(
    Integer userId, String name, String email, Date createAt, UserRole role) {}
