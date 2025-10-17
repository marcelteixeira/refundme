package it.wisecore.refundme.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.wisecore.refundme.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
