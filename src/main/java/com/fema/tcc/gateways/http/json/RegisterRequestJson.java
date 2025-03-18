package com.fema.tcc.gateways.http.json;

import com.fema.tcc.domains.enums.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegisterRequestJson {

  @NotNull private String email;
  @NotNull private String password;
  private UserRole role;
}
