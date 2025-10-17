package it.wisecore.refundme.entities;

import java.sql.SQLException;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private int userId;
	
	@Column(nullable = false)
	private String userName;
	
	@Column(nullable = false)
	private String userLastName;
	
	@Column(nullable = false)
	private String userEmail;
	
	@Column(nullable = false)
	private String companyEmail;
	
	@Column(nullable = false)
	private String message;
	
	@Column(nullable = false)
	private double requestedAmount;
	
	@Column(nullable = false)
	private int situation = 0; //0 - Not approved yet | 1 = Approved | 2 = Declined
	

	
	public Reimbursement(UUID id) throws SQLException {
		
		
		
	}
	

	
	
	
	
}
