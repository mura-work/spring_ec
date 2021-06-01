package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GenreControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	GenreController genre;	// コントローラをテストに読み込み
	
	@Before	// テストの前に実施
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(genre).build();	// springMVCの動作を取得
	}
	
	/**
	 * indexの画面を開いたときのレスポンスHTTPステータスコードは正しいか？
	 * @throws Exception 例外
	 */
	@Test
	public void index() throws Exception {
		mockMvc.perform(get("/genres")).andExpect(status().isOk());
	}
	
	/**
	 * indexの画面を開いたときに正しいviewを返すか？
	 * @throws Exception
	 */
	@Test
	public void indexView() throws Exception {
		mockMvc.perform(get("/genres")).andExpect(status().isOk()).andExpect(view().name("index"));
	}
	
	@Test
	public void indexAttribute() throws Exception {
		mockMvc.perform(get("/genres")).andExpect(status().isOk())
			.andExpect(view().name("index")).andExpect(model().attribute("message", "hello world"));
	}
	
	
}


















