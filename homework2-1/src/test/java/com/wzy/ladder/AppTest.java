package com.wzy.ladder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;
import java.util.HashSet;
import java.io.IOException;
public class AppTest extends TestCase{
	    public void testRead()throws IOException{
	        try{
	        Set<String>wordDict =new HashSet<String>();
	        wordDict = App.Read("C:\\Users\\hp\\Desktop\\wordLadder\\src\\dictionary.txt");
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
	            Set<String>wordDict = App.Read("123.txt");
	            fail("The test is fails");
	        }
	        catch (IOException e){
	            assertTrue(true);
	        }
	    }
	    public void testprintpath(){
	        ArrayList<Node> temp1= new ArrayList<Node>();
	        String result1 = App.printpath(temp1,"a","aa");
	        assertEquals(result1,"Sorry,there isn't a way between two words");
	        ArrayList<Node> temp2= new ArrayList<Node>();
	        temp2.add(new Node("code","",1));
	        temp2.add(new Node("code","code",2));
	        String result2 = App.printpath(temp2,"code","code");
	        assertEquals(result2,"code->code");
	        ArrayList<Node> temp3= new ArrayList<Node>();
	        temp3.add(new Node("code","",1));
	        temp3.add(new Node("cote","code",2));
	        temp3.add(new Node("come","code",2));
	        temp3.add(new Node("cope","code",2));
	        temp3.add(new Node("dote","cote",3));
	        temp3.add(new Node("cote","cote",3));
	        temp3.add(new Node("cate","cote",3));
	        temp3.add(new Node("date","cate",4));
	        String result3 = App.printpath(temp3,"code","date");
	        assertEquals(result3,"code->cote->cate->date");
	        ArrayList<Node> temp4= new ArrayList<Node>();
	        temp4.add(new Node("code","",1));
	        temp4.add(new Node("cote","code",2));
	        temp4.add(new Node("come","code",2));
	        temp4.add(new Node("cope","code",2));
	        temp4.add(new Node("dote","cote",3));
	        temp4.add(new Node("cote","cote",3));
	        temp4.add(new Node("cate","cote",3));
	        temp4.add(new Node("data","cate",4));
	        String result4 =App.printpath(temp4,"code","date");
	        assertEquals(result4,"Sorry,there isn't a way between two words");
	    }
	    public void testBfs(){
	        try{
	        Set<String> wordDict = new HashSet<String>();
	        wordDict = App.Read("C:\\Users\\hp\\Desktop\\wordLadder\\src\\dictionary.txt");
	        ArrayList<Node> temp1 = App.bfs("wonderful","help",wordDict);
	        assertEquals(0,temp1.size());
	        ArrayList<Node> temp2 =App.bfs("code","code",wordDict);
	        assertEquals(App.printpath(temp2,"code","code"),"code->code");
	        ArrayList<Node> temp3 =App.bfs("hate","code",wordDict);
	        assertEquals(App.printpath(temp3,"hate","code"),"hate->cate->cote->code");
	        ArrayList<Node> temp4 =App.bfs("happy","code",wordDict);
	        assertEquals(App.printpath(temp4,"happy","code"),"Sorry,there isn't a way between two words");
	    }
	        catch(IOException e){
	            fail("The test is failed");
	        }
	    }
}

