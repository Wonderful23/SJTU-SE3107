package com.springboot.chapter1.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import junit.framework.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.io.IOException;
import org.junit.After;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class testChapter1Main extends TestCase{
    public testChapter1Main(){ }
    @Autowired
    Chapter1Main temp;
    public MockMvc mockMvc;
    public WebApplicationContext wac;
    @Before
    public void setUp() throws Exception{
        this.mockMvc = MockMvcBuilders.standaloneSetup(temp).build();
    }
    @Test
    public void mockTestA() throws Exception {
        MvcResult result = this.mockMvc.perform(
                get("/templates")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED).param("begin","hate").param("end","data")         //添加参数
        ).andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn();// 获取方法的返回值
        String result1 = (String)result.getModelAndView().getModel().get("result");
        Assert.assertEquals("hate->date->data", result1);
    }
    @Test
    public void testRead()throws IOException {
            try{
                Set<String> wordDict =new HashSet<String>();
                wordDict = Chapter1Main.Read("C:\\Users\\hp\\Desktop\\dictionary.txt");
                assertTrue(wordDict.contains("help"));
                assertTrue(wordDict.contains("world"));
                assertTrue(wordDict.contains("like"));
                assertTrue(wordDict.contains("beauty"));
                assertFalse(wordDict.contains("a123"));
                assertEquals(wordDict.size(),221922);
                assertFalse(wordDict.contains("Adf"));
            }
            catch (IOException e){
                fail("The test is failed");
            }
        }
        @Test
        public void testUnRead()throws IOException{
            try{
                Set<String>wordDict = Chapter1Main.Read("123.txt");
                fail("The test is fails");
            }
            catch (IOException e){
                assertTrue(true);
            }
        }
        @Test
        public void testprintpath(){
            ArrayList<Node> temp1= new ArrayList<>();
            String result1 = Chapter1Main.printpath(temp1,"a","aa");
            assertEquals(result1,"Sorry,there isn't a way between two words");
            ArrayList<Node> temp2= new ArrayList<>();
            temp2.add(new Node("code","",1));
            temp2.add(new Node("code","code",2));
            String result2 = Chapter1Main.printpath(temp2,"code","code");
            assertEquals(result2,"code->code");
            ArrayList<Node> temp3= new ArrayList<>();
            temp3.add(new Node("code","",1));
            temp3.add(new Node("cote","code",2));
            temp3.add(new Node("come","code",2));
            temp3.add(new Node("cope","code",2));
            temp3.add(new Node("dote","cote",3));
            temp3.add(new Node("cote","cote",3));
            temp3.add(new Node("cate","cote",3));
            temp3.add(new Node("date","cate",4));
            String result3 = Chapter1Main.printpath(temp3,"code","date");
            assertEquals(result3,"code->cote->cate->date");
            ArrayList<Node> temp4= new ArrayList<>();
            temp4.add(new Node("code","",1));
            temp4.add(new Node("cote","code",2));
            temp4.add(new Node("come","code",2));
            temp4.add(new Node("cope","code",2));
            temp4.add(new Node("dote","cote",3));
            temp4.add(new Node("cote","cote",3));
            temp4.add(new Node("cate","cote",3));
            temp4.add(new Node("data","cate",4));
            String result4 = Chapter1Main.printpath(temp4,"code","date");
            assertEquals(result4,"Sorry,there isn't a way between two words");
        }
        @Test
        public void testBfs(){
            try{
                Set<String> wordDict = new HashSet<String>();
                wordDict = Chapter1Main.Read("C:\\Users\\hp\\Desktop\\dictionary.txt");
                ArrayList<Node> temp1 = Chapter1Main.bfs("wonderful","help",wordDict);
                assertEquals(0,temp1.size());
                ArrayList<Node> temp2 =Chapter1Main.bfs("code","code",wordDict);
                assertEquals(Chapter1Main.printpath(temp2,"code","code"),"code->code");
                ArrayList<Node> temp3 =Chapter1Main.bfs("hate","code",wordDict);
                assertEquals(Chapter1Main.printpath(temp3,"hate","code"),"hate->cate->cote->code");
                ArrayList<Node> temp4 =Chapter1Main.bfs("happy","code",wordDict);
                assertEquals(Chapter1Main.printpath(temp3,"happy","code"),"Sorry,there isn't a way between two words");
            }
            catch(IOException e){
                fail("The test is failed");
            }
        }
    }
