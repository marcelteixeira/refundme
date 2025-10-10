package it.wisecore.refundme.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import it.wisecore.refundme.services.PropertiesFileReader;

public class ConnectionFactory {

		
		
		public static Connection getConnection() throws SQLException {
			
			Properties connectionProperties = PropertiesFileReader.getProperties();
			
			final String url = connectionProperties.getProperty("database.url");
			final String user = connectionProperties.getProperty("database.user");
			final String password = connectionProperties.getProperty("database.password");
			
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		
		}
	
}
