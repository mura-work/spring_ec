package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.GenreForm;
import com.example.demo.repository.GenreRepository;

@Controller
public class GenreController {
	@Autowired
	GenreRepository repository;
	
	@GetMapping("/genres")
	public String index(@ModelAttribute GenreForm form) {
		return "genres/index";
	}
}
