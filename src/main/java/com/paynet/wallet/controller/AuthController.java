package com.paynet.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String login(ModelMap model,@RequestParam("name") String name,
			@RequestParam("phoneNumber") long phoneNumber, @RequestParam("password") String password) {
		if(!authService.CheckPhoneNumberAndPassword(phoneNumber, password)){
			 model.addAttribute("errorMessage", "Invalid Credentials");
	         return "/signup";
		} 
		if(authService.checkUserExists(phoneNumber).isPresent()) {
			 model.addAttribute("errorMessage", "User Already Exists");
	         return "/signup";
		}
		authService.createUser(name, phoneNumber, password);
		return "/login";
	}

}
