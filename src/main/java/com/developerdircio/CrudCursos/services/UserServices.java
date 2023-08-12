package com.developerdircio.CrudCursos.services;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developerdircio.CrudCursos.UserRepository;
import com.developerdircio.CrudCursos.entities.UserEntity;
import com.developerdircio.CrudCursos.shared.dto.UserDTO;

@Service
public class UserServices implements UserServicesInterfaces {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDTO createUser(UserDTO user){

    if(userRepository.findByEmail(user.getEmail()) != null) 
      throw new RuntimeException("El correo electronico ya existe");

    UserEntity userEntity = new UserEntity();

    BeanUtils.copyProperties(user, userEntity);

    UUID userId = UUID.randomUUID();

    userEntity.setPassword("test1");
    userEntity.setUserId(userId.toString());

    UserEntity storedUserEntity = userRepository.save(userEntity);

    UserDTO userToReturn = new UserDTO();

    BeanUtils.copyProperties(storedUserEntity, userToReturn);

    return userToReturn;
  }
  
}
