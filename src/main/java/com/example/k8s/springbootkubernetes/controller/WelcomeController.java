package com.example.k8s.springbootkubernetes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Value("${test}")
	private String user;
	
	@RequestMapping("/greeting")
	public String greeting() {
		return "Welcome to my youtube channel " + user;
	}

}
