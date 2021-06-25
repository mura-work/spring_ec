package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.example.demo.util.DataTransformationUtil;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CartRestController {
	@Autowired
	CartService service;
	
	@GetMapping("/carts")
	public String index() {
		List<Cart> carts = service.findByCart();
		return DataTransformationUtil.getJsonData(carts);
	}
}
