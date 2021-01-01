package com.example.k8s.springbootkubernetes.controller;

import com.example.k8s.springbootkubernetes.configs.WelcomeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeConfiguration welcomeConfiguration;

	@RequestMapping("/greeting")
	public String greeting() {
		String role = welcomeConfiguration.getRoles().stream().findFirst().get().getRole();
		return "Welcome to my youtube channel " + welcomeConfiguration.getNameUser() + " role: "+ role;
	}

}
