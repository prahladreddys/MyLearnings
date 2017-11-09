package com.prahlad.rest.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/core/v1.0/loans")
public class LoanService {
	@RequestMapping("/ping")
	public String ping(){
		return "Pong from Loan Service";
	}
}
