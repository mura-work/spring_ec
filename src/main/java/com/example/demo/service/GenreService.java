package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;

@Service
public class GenreService {
	@Autowired
	GenreRepository repository;
	
	public String memo(String text) {
		String memo = text + "memo";
		return memo;
	}
	
	public Genre find(int id) {
		Genre genre = repository.findById(id);
		return genre;
	}
}
