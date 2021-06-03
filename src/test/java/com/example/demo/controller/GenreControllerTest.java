package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
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
		mockMvc.perform(get("/genres")).andExpect(status().isOk()).andExpect(view().name("genres/index"));
	}
	
	@Test
	public void indexFail() {
		fail("エラーが発生しました!!");
	}
	
	@Test
	public void check() {
		String actual = "hello" + " " + "world";
		assertThat(actual, is("hello world"));
	}
	
	
}


















