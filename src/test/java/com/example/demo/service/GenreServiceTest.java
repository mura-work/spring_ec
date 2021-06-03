package com.example.demo.service;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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
class GenreServiceTest {
	private MockMvc mockMvc;
	
	@Autowired
	GenreService service;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}
	
	@Test
	public void memoStr() {
		String memo = service.memo("memo");
		assertThat(memo, is("memo"));
	}
	
	@Test
	public void sample() {
		fail("エラー");
	}

}
