package com.fema.tcc.domains.user;

import com.fema.tcc.domains.enums.UserRole;
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
  private UserRole role;

  public User(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public User(Integer userId, String name, String email, Date createAt, UserRole role) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.createAt = createAt;
    this.role = role;
  }

  public User(String name, String email, String password, UserRole role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
