package it.wisecore.refundme;

import java.util.Properties;

import it.wisecore.refundme.services.EmailService;
import it.wisecore.refundme.services.PropertiesFileReader;

public class TesteRapido {

	public static void main(String[] args) {
		
		EmailService ms3 = new EmailService();
		ms3.emailTester();

	}

}
