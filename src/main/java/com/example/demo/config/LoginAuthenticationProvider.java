package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.EmployeeRepository;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	EmployeeRepository repository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String empId = auth.getName();
		String password = auth.getCredentials().toString();
		
		if(empId.equals("") && password.equals("")) {
			throw new UsernameNotFoundException("");
		}
		
		Employee emp = repository.findByIdAndPassword(Integer.parseInt(empId), password);
		
		if(emp == null) {
			throw new UsernameNotFoundException("");
		}
		
		return new UsernamePasswordAuthenticationToken(new LoginForm(emp), password, auth.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> token) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(token);
	}

}
