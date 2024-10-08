package com.example.demo.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.UserDtls;
import com.example.demo.service.UserService;


@Controller

public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		
		return "register";
		
	}

	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user, HttpSession session)

	{
		
		
		
		boolean f = userService.checkEmail(user.getEmail());

		if (f) {

			session.setAttribute("msg", "Email Id already exists");
			
		}

		else {
			UserDtls userDetails = userService.createUser(user);
			if (userDetails != null) {

				session.setAttribute("msg", "Register Sucessfully");

			} else {
				session.setAttribute("msg", "Something Went wrong on server");
			}

		}

		return "redirect:/register";

	}

}
