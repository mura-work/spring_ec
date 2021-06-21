package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	
	/**
	 * 社員全件取得
	 * @return
	 */
	public List<Employee> findEmpAll(){
		List<Employee> emp = repository.findAll();
		return emp;
	}
	
	/**
	 * 社員一件取得
	 * @param id
	 * @return
	 */
	public Employee findEmp(int id) {
		Employee emp = repository.findById(id).get();
		return emp;
	}
}
