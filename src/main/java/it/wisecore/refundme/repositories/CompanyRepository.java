package it.wisecore.refundme.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.wisecore.refundme.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID>{

}
