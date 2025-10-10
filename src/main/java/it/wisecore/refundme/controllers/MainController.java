package it.wisecore.refundme.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.wisecore.refundme.entities.Reimbursement;
import it.wisecore.refundme.entities.User;
import it.wisecore.refundme.services.EmailService;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home() {
		return "home";
		
	}

	
	@GetMapping("/newRequest")
	public String newRequest(Model model) {
		model.addAttribute("reimbursement", new Reimbursement());
		return "newRequest";
	}

	
	
	
	
	@GetMapping("/newRequest/view")
	public String newRequestView(@RequestParam(name="reimbursementId", required=false) Integer reimbursementId, Model model) throws SQLException {
		
		Reimbursement reimbursement = new Reimbursement(reimbursementId);
		model.addAttribute("reimbursement", reimbursement);
		return "requestView";
	}
	
	
	
	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/user/save")
	public String submitForm(Model model, @ModelAttribute("user") User user) throws SQLException {
		model.addAttribute("user", user);
		user.userCreate();
		
		return "home";
	}
	
	@Autowired private EmailService emailService;
	@PostMapping("/newRequest/save")
	public String newRequestSave(Model model, @ModelAttribute("reimbursement") Reimbursement reimbursement) throws SQLException {
		
		int id = reimbursement.create();
		emailService.sendEmail(reimbursement);
		
		
		return "redirect:/newRequest/view?reimbursementId=" + id;
	}
	
	
	/*
	@Autowired private EmailService emailService;
	@GetMapping("/mail-test")
	public String sendEmail() {
		
		emailService.sendEmail();
		return "redirect:/home";
	}
	*/
	
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}

}



