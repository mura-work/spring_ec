package com.example.demo.controller;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.GenreController;

public class GenresControllerTest {

private MockMvc mockMvc;
	
	@Autowired
	GenreController genre;	// コントローラをテストに読み込み
	
	@Before	// テストの前に実施
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(genre).build();	// springMVCの動作を取得
	}

}
