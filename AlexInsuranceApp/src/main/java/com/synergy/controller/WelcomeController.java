package com.synergy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/welcome")
	public String welcome(ModelMap model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		  String userName = ((UserDetails)principal).getUsername();
		  model.addAttribute("userName", userName);
		} else {
		  String userName = principal.toString();
		  model.addAttribute("userName", userName);
		}
		return "home";
	}
	
	@RequestMapping(value = "/customerClaims/{role}")
	public String loadClaimsPage(@PathVariable String role) {
		System.out.println(role.equals("admin"));
		if (role.equals("admin")) {
			return "admin";
		} else {
			return "claims";
		}
	}
	
	@GetMapping(value = "/checkout/{userName}")
	public String loadCheckout() {
		return "checkout";
	}
}