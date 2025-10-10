package it.wisecore.refundme.entities;

import java.sql.SQLException;
import java.sql.Statement;

public class SchemaCreation {
	
	
	
	
	public void createDataBase() throws SQLException {
		Statement stmt = ConnectionFactory
				.getConnection()
				.createStatement();
		
		try {
			stmt.execute("CREATE IF NOT EXISTS refundme");	
			System.out.println("DataBase Created...");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		
		
		
	}
	
	
	
	

}
