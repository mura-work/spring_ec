package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.RegistForm;
import com.example.demo.service.RegistService;

@Controller
public class EmployeeController {
	@Autowired
	RegistService service;
	
	@GetMapping("/regist")
	public String regist(@ModelAttribute RegistForm form) {
		return "emp/regist";
	}
	
	@PostMapping("/regist")
	public String registration(@Valid @ModelAttribute RegistForm form,
			BindingResult result) {
		if (result.hasErrors()) {
			return "emp/regist";
		}
		service.register(form);
		return "redirect:/login";
	}
}
