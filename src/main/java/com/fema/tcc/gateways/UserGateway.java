package com.fema.tcc.gateways;

import com.fema.tcc.domains.user.User;

public interface UserGateway {

  User save(User user);

  boolean existsByEmail(String email);
}
