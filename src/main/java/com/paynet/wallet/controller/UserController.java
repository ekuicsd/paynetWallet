package com.paynet.wallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping(value="/addMoney")
	public String addMoneyPage() {
		return "add-money";
	}
	
	@GetMapping(value="/transferMoney")
	public String transferMoneyPage() {
		return "transfer-money";
	}
	
	@GetMapping(value="/transactions")
	public String transactionPage() {
		return "transactions";
	}
}
