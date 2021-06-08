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
}
