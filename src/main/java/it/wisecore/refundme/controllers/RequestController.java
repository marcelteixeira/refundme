package it.wisecore.refundme.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/requests")
public class RequestController {

	@GetMapping()
	public String getRequests() {
		return "GET - Request page";
	}
	
	
	@GetMapping(path="/send")
	public String getSendRequest() {
		return "Request Sended";
	}
	
	@PostMapping(path="/send")
	public String sendRequest(){
		return "POST Request sended";
	}
	
}

