package com.paynet.wallet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paynet.wallet.model.User;
import com.paynet.wallet.service.UserService;
import com.paynet.wallet.util.TransactionType;

@Controller
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value="/home")
	public String homePage() {
		return "home";
	}

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
	
	@PostMapping(value="/addMoney")
	public String addMoney(ModelMap model, HttpServletRequest request) {
		String cardNumber = request.getParameter("cardNumber");
		String name = request.getParameter("name");
		int month = Integer.parseInt(request.getParameter("month"));
		int year = Integer.parseInt(request.getParameter("year"));
		String cvv = request.getParameter("cvv");
		long amount = Long.parseLong(request.getParameter("amount"));
		String errorMessage = userService.checkAddMoneyDetails(cardNumber, name, month, year, cvv, amount);
		System.out.println(errorMessage);
		if(errorMessage != null) {
			 model.addAttribute("errorMessage", errorMessage);
			 return "add-money";
		}
		userService.addMoney((User)request.getSession().getAttribute("user"), TransactionType.ADD_MONEY, amount);
		return "redirect:home";
	}
}
