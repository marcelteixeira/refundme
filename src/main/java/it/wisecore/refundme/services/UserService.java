package it.wisecore.refundme.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.wisecore.refundme.entities.Account;
import it.wisecore.refundme.entities.User;
import it.wisecore.refundme.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AccountService accountService;
	
	public UUID save(User user, Account account) {
		UUID accountID = accountService.save(account);
		user.setId(accountID);
		
		
		User saved = userRepository.save(user);
		return saved.getId();
	}
}
