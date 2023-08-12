package com.developerdircio.CrudCursos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.developerdircio.CrudCursos.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  UserEntity findByEmail(String email);
  
}
