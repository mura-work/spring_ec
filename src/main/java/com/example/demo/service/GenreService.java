package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GenreService {
	
	public String memo(String text) {
		String memo = text + "memo";
		return memo;
	}
}
