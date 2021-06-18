package com.example.demo.form;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo.entity.Employee;

public class LoginForm extends User {
	private Integer empId;
	private String password;
	
	private User user;
	
//	public LoginForm(Employee emp) {
//    super(emp.StringEmpId(), emp.getPassword(), emp.getEnable(), true, true,
//        true, convertGrantedAuthorities(emp.getRoles()));
//    this.user = user;
//  }
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginForm(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public LoginForm(Employee emp) {
		super(emp.StringEmpId(), emp.getPassword(), true, true, true, true, new ArrayList<GrantedAuthority>());
		empId = emp.getId();
		password = emp.getPassword();
	}
	
}
