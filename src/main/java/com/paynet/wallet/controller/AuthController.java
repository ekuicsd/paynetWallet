package com.paynet.wallet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.paynet.wallet.model.User;
import com.paynet.wallet.service.AuthService;

@Controller
public class AuthController {
	
	@Autowired
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping({"", "/", "/login"})
	public String loginPage() {
		return "login";
	}
	
	@GetMapping({"/signup"})
	public String SignupPage() {
		return "signup";
	}
	
	@PostMapping(value="/signup")
	public String login(ModelMap model, HttpServletRequest request) {
		String name = request.getParameter("name");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String password = request.getParameter("password");
		if(!authService.CheckPhoneNumberAndPassword(phoneNumber, password)){
			 model.addAttribute("errorMessage", "Invalid Credentials");
	         return "signup";
		} 
		if(authService.checkUserExists(phoneNumber).isPresent()) {
			 model.addAttribute("errorMessage", "User Already Exists");
	         return "signup";
		}
		User user = authService.createUser(name, phoneNumber, password);
		request.getSession().setAttribute("user",user);
		return "redirect:home";
	}
	
	
	@PostMapping(value="/login")
	public String signup(ModelMap model, HttpServletRequest request) {
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String password = request.getParameter("password");
		if(!authService.CheckPhoneNumberAndPassword(phoneNumber, password)){
			 model.addAttribute("errorMessage", "Invalid Credentials");
	         return "login";
		} 
		if(!authService.checkUserExists(phoneNumber).isPresent()) {
			 model.addAttribute("errorMessage", "User does not exists");
	         return "login";
		}
		if(!authService.isExistByPhoneNumberAndPasword(phoneNumber, password)) {
			 model.addAttribute("errorMessage", "Password does not match");
			return "login";
		}
		User user = authService.findByPhoneNumber(phoneNumber);
		request.getSession().setAttribute("user",user);
		return "redirect:home";
	}
	
}
