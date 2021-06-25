package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class CartService {
	@Autowired
	CartRepository repository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Cart> findByCart(){
//		List<Cart> carts = repository.findByEmpId(LoginSession.loginUser());
		List<Cart> carts = repository.findByEmployee(employeeRepository.findById(1).get());
		return carts;
	}
}	
