package com.fema.tcc.domains.user;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Integer userId;
  private String name;
  private String email;
  private String password;
  private Date createAt;
  private String role;

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
