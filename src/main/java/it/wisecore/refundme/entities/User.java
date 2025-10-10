package it.wisecore.refundme.entities;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

	private int id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public void userCreate() throws SQLException {
		
		String sql = "insert into user (name, lastName, email, password) values(?, ?, ?, ?)";
		
		PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
		stmt.setString(1, this.getName());
		stmt.setString(2, this.getLastName());
		stmt.setString(3, this.getEmail());
		stmt.setString(4, this.getPassword());
		
		stmt.execute();
		
		
		}
	
}
