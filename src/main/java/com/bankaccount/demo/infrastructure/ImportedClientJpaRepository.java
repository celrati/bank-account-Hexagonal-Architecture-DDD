package com.bankaccount.demo.infrastructure;

import com.bankaccount.demo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ImportedClientJpaRepository extends JpaRepository<Client, Long> {

    Optional<Client> findOneById(Long id);
}
