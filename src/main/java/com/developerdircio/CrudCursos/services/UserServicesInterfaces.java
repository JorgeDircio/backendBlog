package com.developerdircio.CrudCursos.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.developerdircio.CrudCursos.shared.dto.UserDTO;

public interface UserServicesInterfaces extends UserDetailsService {

  public UserDTO createUser(UserDTO user);
  
}
