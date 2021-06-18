package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class LoginLogic implements UserDetailsService {
	@Autowired
	EmployeeRepository repository;

	@Override
	public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
		Employee emp = repository.getOne(Integer.parseInt(empId));
		if (emp == null) {
			throw new UsernameNotFoundException("User" + empId + "アカウントが存在しません");
		}
		return (UserDetails) emp;
	}

}
