package it.wisecore.refundme.entities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.PreparedQuery;

public class Reimbursement {
	
	private int id;
	private int userId;
	private String userName;
	private String userLastName;
	private String userEmail;
	private String companyEmail;
	private String message;
	private double requestedAmount;
	private int situation = 0; //0 - Not approved yet | 1 = Approved | 2 = Declined
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(int id) throws SQLException {
		
		select(id);
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	
	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}
	
	

	public int  create() throws SQLException {
		int id;
		String sql = "INSERT INTO reimbursement (userName, userLastName, userEmail, companyEmail, message, requestedAmount) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userName);
		stmt.setString(2, userLastName);
		stmt.setString(3, userEmail);
		stmt.setString(4, companyEmail);
		stmt.setString(5, message);
		stmt.setDouble(6, requestedAmount);
		
		stmt.executeUpdate();
		ResultSet resultSet = stmt.getGeneratedKeys();
		
		
		if(resultSet.next()){
			id = resultSet.getInt(1);
			System.out.println(id);
			return id;
			
		}else {
			return -1;
		}
		
		
		
	}
	
	
	
	
	
	
	public void select(int id) throws SQLException {
		
		String sql = "SELECT * FROM reimbursement where id = ?";
		PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet resultSet = stmt.executeQuery();
		
		
		if(resultSet.next()) {
			this.id = resultSet.getInt("id");
			this.userId = resultSet.getInt("userID");
			this.userName = resultSet.getString("userName");
			this.userLastName = resultSet.getString("userLastName");
			this.userEmail = resultSet.getString("userEmail");
			this.companyEmail = resultSet.getString("companyEmail");
			this.message = resultSet.getString("message");
			this.requestedAmount = resultSet.getDouble("requestedAmount");
			this.situation = resultSet.getInt("isApproved");
			
			
		}
		stmt.close();
	}
	
	
	
	
	
	
}
