package com.petbook.petbook.services.repository;

import com.petbook.petbook.services.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountEntityRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByEmailAddress(String emailAddress);
}
