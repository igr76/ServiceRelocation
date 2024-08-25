package org.example.servicerelocation.repository;


import org.example.servicerelocation.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Репозиторий пользователей */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    Optional<UserEntity> findByEmail(String email);

    Optional<Object> findByName(String name);
    boolean findByNameIsNotNull(String login);

  //  UserDetails findByUsername(String username);

}
