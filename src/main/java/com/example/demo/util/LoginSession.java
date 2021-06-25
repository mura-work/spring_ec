package com.example.demo.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;


public class LoginSession {
	
  public static Employee loginUser() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication auth = context.getAuthentication();
    return (Employee) auth.getPrincipal();
  }
}
