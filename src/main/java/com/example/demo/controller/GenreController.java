package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Genre;
import com.example.demo.form.GenreForm;
import com.example.demo.repository.GenreRepository;

@Controller
public class GenreController {
	@Autowired
	GenreRepository repository;
	
	@GetMapping("/genres")
	public String index(@ModelAttribute GenreForm form, Model model) {
		model.addAttribute("genres", repository.findAll());
		return "genres/index";
	}
	
	@PostMapping("/genres")
	public String create(@Valid @ModelAttribute GenreForm form, BindingResult result) {
		if (result.hasErrors()){
			return "redirect:/genres";
		}
		Genre genre = new Genre();
		genre.setName(form.getName());
		repository.save(genre);
		return "redirect:/genres";
	}
	
}
