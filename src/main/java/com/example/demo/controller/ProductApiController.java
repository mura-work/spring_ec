package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.util.DataTransformationUtil;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProductApiController {
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/products")
	@CrossOrigin
	public String index(){
		List<Product> products = service.findAll();
//		List<Product> products = service.findName(form);
		return DataTransformationUtil.getJsonData(products);
	}

}