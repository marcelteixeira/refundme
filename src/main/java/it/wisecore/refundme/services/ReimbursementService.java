package it.wisecore.refundme.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.wisecore.refundme.entities.Reimbursement;
import it.wisecore.refundme.repositories.ReimbursementRepository;


@Service
public class ReimbursementService {
	
	
	@Autowired
	private ReimbursementRepository repository;
	
	public Reimbursement save(Reimbursement reimbursement) {
	 	
	 	return repository.save(reimbursement);
	}
	
	public Reimbursement findById(UUID id) {
	
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Reimbursement not found"));
		
		
		
	}

}
