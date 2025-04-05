package com.fema.tcc.gateways.http.jsons;

import com.fema.tcc.domains.enums.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegisterRequestJson {

  @NotNull private String name;
  @NotNull private String email;
  @NotNull private String password;
  @NotNull private UserRole role;
}
