package com.developerdircio.CrudCursos.services;
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

    System.out.println("user => " + user);

    UserEntity userEntity = new UserEntity();

    BeanUtils.copyProperties(user, userEntity);

    userEntity.setPassword("test1");
    userEntity.setUserId("148ddj");

    UserEntity storedUserEntity = userRepository.save(userEntity);

    UserDTO userToReturn = new UserDTO();

    BeanUtils.copyProperties(storedUserEntity, userToReturn);

    return userToReturn;
  }
  
}
