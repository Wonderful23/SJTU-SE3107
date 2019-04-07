package com.springboot.chapter1.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import junit.framework.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

public class testChapter1Main extends TestCase{
        public testChapter1Main(String name){
            super(name);
        }
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
        public void testUnRead()throws IOException{
            try{
                Set<String>wordDict = Chapter1Main.Read("123.txt");
                fail("The test is fails");
            }
            catch (IOException e){
                assertTrue(true);
            }
        }
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
