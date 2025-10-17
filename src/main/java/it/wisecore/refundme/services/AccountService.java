package it.wisecore.refundme.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.wisecore.refundme.entities.Account;
import it.wisecore.refundme.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public UUID save(Account account) {
		Account savedAccount = accountRepository.save(account);
		return savedAccount.getId();
		
		
	}

}
