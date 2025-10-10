package it.wisecore.refundme.services;

import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {


	public static Properties getProperties() {
		
		Properties properties = new Properties();
		try {
			properties.load(PropertiesFileReader.class.getResourceAsStream("/application.properties"));
		} catch (IOException | NullPointerException e) {
			System.err.println("Not able to open properties file. " + e.getLocalizedMessage());
		}
		
		
		
		
		return properties;
	}



}
