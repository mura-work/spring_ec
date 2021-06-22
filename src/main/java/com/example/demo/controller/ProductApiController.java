package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductApiController {
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/products")
	@CrossOrigin
	public List<Product> index(){
		List<Product> products = service.findAll();
		return products;
	}
	
	@RequestMapping("/pro")
	public Pro getPro() {
		return new Pro("pro");
	}
}

class Pro {
	private String info;

	public Pro(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}