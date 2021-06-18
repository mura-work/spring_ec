package com.example.demo.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@Service
public class LoginService {
	
  public void loginUser() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();
//    Employee loginUser = (Employee) authentication.getPrincipal();
//    log.info("#doService id:{}, name:{}", loginUser.getUser().getId(), loginUser.getUser().getName());
  }
}
