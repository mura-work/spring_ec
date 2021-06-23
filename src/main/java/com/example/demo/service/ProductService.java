package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.form.ProductForm;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService { 
		@Autowired
		ProductRepository repository;
	public List<Product> findAll(){
		List<Product> products = repository.findAll();
		return products;
	}
	
	public List<Product> findName(ProductForm form){
		List<Product> pro = repository.findByNameLike(form.getName());
		return pro;
	}
}
