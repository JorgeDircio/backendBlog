package com.developerdircio.CrudCursos.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developerdircio.CrudCursos.models.requests.UserDetailRequestModel;
import com.developerdircio.CrudCursos.models.responses.UserRest;
import com.developerdircio.CrudCursos.services.UserServicesInterfaces;
import com.developerdircio.CrudCursos.shared.dto.UserDTO;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

  @Autowired
  UserServicesInterfaces userService;
  
  @GetMapping
  public String getUser(){
    return "get user";
  }

  @PostMapping
  public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){
    //Crear e objeto de retorno
    UserRest userToReturn = new UserRest();

    //crear el objeto dto que se enviara a la logica de negocio
    UserDTO userDto = new UserDTO();

    //Copiar las propiedad que vienen en el body al objeto dto para la logica de negocio
    BeanUtils.copyProperties(userDetails, userDto);

    //mandar a llamar el servicio de la logica de negocio y crear un objeto dto para guardar lo que retorna la logica de negocio
    UserDTO createUser = userService.createUser(userDto);

    //Una vez retornando lo que retorna la logica de negocio, copoar las propiedades al objeto que se retorna en la respuesta
    BeanUtils.copyProperties(createUser, userToReturn);

    return userToReturn;

  }
}
