package it.wisecore.refundme.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.wisecore.refundme.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{

}
