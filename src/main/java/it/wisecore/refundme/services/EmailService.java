package it.wisecore.refundme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import it.wisecore.refundme.entities.Reimbursement;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	
	public void sendEmail(Reimbursement reimbursement) {
		
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo(reimbursement.getCompanyEmail());
			helper.setSubject("refundMe - Reimbursement Requested");
			helper.setFrom(reimbursement.getUserEmail());
			
			String htmlContent = """
					<div style="font-family: Arial, sans-serif; max-width: 600px; margin: auto; border: 1px solid #ddd; border-radius: 8px;">
            <div style="background-color: #2563eb; padding: 20px; color: white; text-align: center; font-weight: bold; border-radius: 8px 8px 0 0;">
                New Reimbursement Request
            </div>

            <div style="padding: 20px;">
                <p style="color: #333;">A new reimbursement request has been submitted with the following details:</p>
                <table style="width: 100%; font-size: 14px; color: #333;">
                    <tr><td><b>Name:</b></td><td> {{getUserName}} {{getUserLastName}} </td></tr>
                    <tr><td><b>Email:</b></td><td>{{getUserEmail}}</td></tr>
                    <tr><td><b>Company Email:</b></td><td>{{getCompanyEmail}}</td></tr>
                    <tr><td><b>Requested Amount:</b></td><td>$ {{getRequestedAmount}}</td></tr>
                    <tr><td><b>Message:</b></td><td>{{getMessage}}</td></tr>
                </table>

                <div style="margin-top: 20px; background-color: #e9f2ff; padding: 10px; border-radius: 4px; text-align: center;">
                    Please review this request and take the necessary action.
                </div>
            </div>

            <div style="background-color: #f9f9f9; text-align: center; padding: 10px; font-size: 12px; color: #777; border-radius: 0 0 8px 8px;">
                © 2025 WiseCore IT – refundMe
            </div>
        </div>	
					""";
			
			
			htmlContent = htmlContent
					.replace("{{getUserName}}", reimbursement.getUserName())
					.replace("{{getUserLastName}}",reimbursement.getUserLastName())
					.replace("{{getUserEmail}}", reimbursement.getUserEmail())
					.replace("{{getCompanyEmail}}", reimbursement.getCompanyEmail())
					.replace("{{getRequestedAmount}}", Double.toString(reimbursement.getRequestedAmount()))
					.replace("{{getMessage}}", reimbursement.getMessage());
			
			
			helper.setText(htmlContent, true);
			mailSender.send(message);
			System.out.println("✅ Email HTML enviado com sucesso!");
			
			
			
		} catch (MessagingException e) {
			System.err.println("Falha ao enviar email  - ");
			e.getLocalizedMessage();
		}
		
	}
	
	
	
	public void emailTester() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("mmtf1r@gmail.com");
		message.setSubject("Email teste");
		message.setText("corpo da mensagem");
		
		mailSender.send(message);
		
	}

}


