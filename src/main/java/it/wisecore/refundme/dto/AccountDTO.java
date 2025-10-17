package it.wisecore.refundme.dto;

import java.util.UUID;

import lombok.Data;


@Data
public class AccountDTO {

	
	private UUID id;
	private boolean isCompany;
	private String password;
	
	// User login
	private String userName;
	private String userLastName;
	private String userEmail;
	
	
	// Company Login
	private String companyName;
	private String companyEmail;
	
	
	
	
	
}
