package com.SecuCom.SecuCom.Repositories;

import com.SecuCom.SecuCom.Modeles.Lows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RepositoryLow extends JpaRepository<Lows, Long> {

    Optional<Lows> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO LOWS (name) VALUES (\"ADMIN\");",nativeQuery = true)
    void creationRole();

}
