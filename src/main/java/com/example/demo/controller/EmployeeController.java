package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employees")
	public String index(Model model) {
		model.addAttribute("employees", service.findEmpAll());
		return "emp/index";
	}
	
	@GetMapping("/employees/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("employeeForm", service.findEmp(id));
		return "emp/edit";
	}
}
