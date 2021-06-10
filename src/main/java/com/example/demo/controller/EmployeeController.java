package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/login")
	public String login() {
		return "emp/login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/emp/login";
	}
}
