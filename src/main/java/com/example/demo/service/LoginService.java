package com.example.demo.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
  public void loginUser() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();
    UserDetails loginUser = (UserDetails) authentication.getPrincipal();
    
//    Employee loginUser = (Employee) authentication.getPrincipal();
//    log.info("#doService id:{}, name:{}", loginUser.getUser().getId(), loginUser.getUser().getName());
  }
}
