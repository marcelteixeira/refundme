package it.wisecore.refundme.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import it.wisecore.refundme.entities.Company;
import it.wisecore.refundme.repositories.CompanyRepository;

public class CompanyService {
	
	
	@Autowired
	private  CompanyRepository companyRepository;
	public UUID save(Company company) {
		Company saved = companyRepository.save(company);
		return saved.getId();
	}

}
