package com.SecuCom.SecuCom.Repositories;

import com.SecuCom.SecuCom.Modeles.Users;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RepositoryUsers extends JpaRepository<Users , Long> {


    Optional<Users> findByEmail(String email);
    Optional<Users> findByUsernameOrEmail(String username, String email);
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


    //String b = passwordEncoder.encode("passe");
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USERS (email,name,password,username) VALUES ('adama@c.com', 'coulibaly', 'adama123', 'adama');",nativeQuery = true)
    void creationUsers();

/*
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_roles (user_id,role_id) VALUES (1,1);",nativeQuery = true)
    void accorderRoles();


 */



}
