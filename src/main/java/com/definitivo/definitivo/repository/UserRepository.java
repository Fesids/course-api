package com.definitivo.definitivo.repository;


import com.definitivo.definitivo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query(value = "select * from user where email =: email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);*/

    //@Query()
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
