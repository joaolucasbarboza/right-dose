package com.fema.tcc.usecases.auth;

import com.fema.tcc.domains.user.User;
import com.fema.tcc.gateways.UserGateway;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUseCase {

  private final UserGateway userGateway;

  public RegisterUseCase(UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  public User execute(User user) {

    if (userGateway.existsByEmail(user.getEmail())) {
      throw new RuntimeException("User already exists");
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    User newUser = new User(user.getName(), user.getEmail(), encryptedPassword, user.getRole());

    return userGateway.save(newUser);
  }
}
