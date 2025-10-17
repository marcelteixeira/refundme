package it.wisecore.refundme.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.wisecore.refundme.entities.Reimbursement;


@Repository
public interface ReimbursementRepository extends JpaRepository<Reimbursement, UUID>{

}
