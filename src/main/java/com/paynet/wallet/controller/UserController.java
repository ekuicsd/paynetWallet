package com.paynet.wallet.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paynet.wallet.model.Transactions;
import com.paynet.wallet.model.User;
import com.paynet.wallet.service.AuthService;
import com.paynet.wallet.service.UserService;
import com.paynet.wallet.util.TransactionType;

@Controller
public class UserController {
	
	@Autowired
	private final UserService userService;
	@Autowired
	private final AuthService authService;
	
	public UserController(UserService userService, AuthService authService) {
		this.userService = userService;
		this.authService = authService;
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
	public String transactionPage(ModelMap model, HttpServletRequest request) {
		ArrayList<Transactions> list = userService.findAllTransactions((User)request.getSession().getAttribute("user"));
		 model.addAttribute("transactionsList", list);
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
		if(errorMessage != null) {
			 model.addAttribute("errorMessage", errorMessage);
			 return "add-money";
		}
		User user = userService.addMoney((User)request.getSession().getAttribute("user"), TransactionType.ADD_MONEY, amount);
		request.getSession().setAttribute("user", user);
		return "redirect:home";
	}
	
	@PostMapping(value="/transferMoney")
	public String transferMoney(ModelMap model, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		long amount = Long.parseLong(request.getParameter("amount"));
		if(user.getPhoneNumber() == phoneNumber) {
			model.addAttribute("errorMessage", "Please enter valid phone number!");
			return "transfer-money";
		} else if(amount <= 0) {
			model.addAttribute("errorMessage", "Please enter amount to transfer!");
			return "transfer-money";
		} else if(!authService.checkUserExists(phoneNumber).isPresent()) {
			model.addAttribute("errorMessage", "You entered wrong phone Number!");
			return "transfer-money";
		} else if(user.getWallet() < amount ) {
			model.addAttribute("errorMessage", "You not have enough balance in your wallet!");
			return "transfer-money";
		}
		User user1 = authService.findByPhoneNumber(phoneNumber);
		User fuser = userService.addMoney(user, TransactionType.DEBITED, amount * -1);
		userService.addMoney(user1, TransactionType.CREDITED, amount);
		request.getSession().setAttribute("user", fuser);
		return "redirect:home";
	}
	
}





