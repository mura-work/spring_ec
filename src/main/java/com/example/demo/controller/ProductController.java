package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping("/products")
	public String index(Model model) {
		model.addAttribute("products", repository.findAll());
		return "products/index";
	}
	
	@GetMapping("/products/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute("product", repository.findById(id).get());
		return "products/show";
	}
}
