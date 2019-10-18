package com.fd.springbootprojects.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	
	@GetMapping(value="/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping(value="/login")
	public String loginForm() {
		return "login.html";
	}

	
	
}
