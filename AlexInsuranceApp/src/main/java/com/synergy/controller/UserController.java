package com.synergy.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.synergy.domain.User;
import com.synergy.service.UserPolicyService;
import com.synergy.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller

@SessionAttributes("user")
public class UserController {
	
	@Autowired UserService userService;
	@Autowired UserPolicyService userPolicy;

	@GetMapping(value = "/login")
	public String login(@RequestParam(required = false) String logout, @RequestParam(required = false) String error,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
		String message = "";
		if (error != null) {
			message = "Invalid Credentials";
		}
		if (logout != null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message = "Logout";
			return "login";
		}
		model.addAttribute("Message", message);
		return "login";

	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		String userPassword = user.getUserPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		userPassword = passwordEncoder.encode(userPassword);
		user.setUserPassword(userPassword);
		
		return userService.save(user);
	}
	
	@GetMapping(value= "/register")
	public String register()
	{
		return "register";
	}
	
	@GetMapping(value = "/accessDeniedPage")
	public String accessDenied(Principal principal, Model model) {
		String message = principal.getName() + ", Unauthorised access";
		model.addAttribute("Message", message);
		return "accessDenied";

	}

	@GetMapping(value = "/signup")
	public String signup() {
		return "signup";
	}
	
	@GetMapping(value = "/user/{username}")
	@ResponseBody
	public String getUserByUsername(@PathVariable String username) {
		return userService.findByUserName(username).getUserName();
	}


//	@Bean
//	public BCryptPasswordEncoder bCryptpeasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}