package com.example.demo;
import junit.framework.*;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests extends TestCase{
	public DemoApplicationTests(){ }
	@Autowired
	public FindServeController temp;
	public MockMvc mockMvc;
	public WebApplicationContext wac;
	public  MockHttpServletResponse response;
	@Before
	public void setUp() throws Exception{
		this.mockMvc = MockMvcBuilders.standaloneSetup(temp).build();
		response = new MockHttpServletResponse();
	}
	@Test
	public void mockTestA() throws Exception {
		MvcResult result = this.mockMvc.perform(
				post("/login")    //请求的url,请求的方法是get
						.contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username","test").param("password","123456")         //添加参数
		).andExpect(status().isOk()).andExpect(content().string(equalTo("1")))    //返回的状态是200
				.andDo(print())         //打印出请求和相应的内容
				.andReturn();// 获取方法的返回值
	}

}
