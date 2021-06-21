package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.form.RegistForm;
import com.example.demo.repository.EmployeeRepository;

@Service
public class RegistService {
	@Autowired
	EmployeeRepository repository;
	
	private final PasswordEncoder passwordEncoder;
	
	public RegistService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	/**
  *
  * @param rawPassword 平文のパスワード
  * @return 暗号化されたパスワード
  */
	 private String passwordEncode(String rawPassword) {
	   return passwordEncoder.encode(rawPassword);
	 }
	 
	 /**
	  * 社員登録処理
	 * @param form 社員登録情報
	 */
	public void register(RegistForm form) {
		 Employee emp = new Employee();
		 emp.setName(form.getName());
		 emp.setEmail(form.getEmail());
		 String encodedPassword = passwordEncode(form.getPassword());
		 emp.setPassword(encodedPassword);
		 emp.setRole(form.getRole());
		 repository.save(emp);
	 }

	

}




