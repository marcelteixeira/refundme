package it.wisecore.refundme.controllers;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.wisecore.refundme.dto.AccountDTO;
import it.wisecore.refundme.entities.Account;
import it.wisecore.refundme.entities.Company;
import it.wisecore.refundme.entities.Reimbursement;
import it.wisecore.refundme.entities.User;
import it.wisecore.refundme.repositories.AccountRepository;
import it.wisecore.refundme.services.CompanyService;
import it.wisecore.refundme.services.EmailService;
import it.wisecore.refundme.services.ReimbursementService;
import it.wisecore.refundme.services.UserService;

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

	
	
	
	@Autowired private ReimbursementService reimbursementServices;
	@GetMapping("/newRequest/view")
	public String newRequestView(@RequestParam(name="reimbursementId", required=false) UUID reimbursementId, Model model) throws SQLException {
		
		Reimbursement reimbursement = reimbursementServices.findById(reimbursementId);
		model.addAttribute("reimbursement", reimbursement);
		return "requestView";
	}
	
	
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		//AccountDTO account = new AccountDTO();
		model.addAttribute("account", new AccountDTO());
		return "login";
	}
	
	@Autowired private UserService userService;
	@PostMapping("/user/save")
	public String newUserProcess(Model model, 
			@ModelAttribute("account")AccountDTO accountDTO) throws SQLException {
		model.addAttribute("account", accountDTO);
		
		
		
		
		return "home";
	}
	
	@Autowired private EmailService emailService;
	@Autowired private ReimbursementService rs;
	@PostMapping("/newRequest/save")
	public String newRequestSave(Model model, @ModelAttribute("reimbursement") Reimbursement reimbursement) throws SQLException {
		Reimbursement saved = rs.save(reimbursement);
		System.out.println(saved.getId());
		//emailService.sendEmail(reimbursement);
	
		
		return "redirect:/newRequest/view?reimbursementId=" + saved.getId();
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



