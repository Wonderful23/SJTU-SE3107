package com.springboot.chapter1.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;
import java.util.HashSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
class Node{
	String word,preWord;
	int distance;
	Node(String w,String p,int d){
		word =w;
		preWord = p;
		distance= d;
	}
}
@SpringBootApplication
@Controller
public class Chapter1Main {
	
	public static void main(String[] args) {
		SpringApplication.run(Chapter1Main.class, args);
	}
	

	public static ArrayList<Node> bfs(String begin, String end, Set<String> wordDict){
		ArrayList<Node>visit=new ArrayList<Node>();
		Set<String>vi = new HashSet<String>();
		if(begin==end){
			visit.add(new Node(begin,"",1));
			visit.add(new Node(end,begin,2));
			return visit;
		}
		Queue<Node> que= new LinkedList<Node>();
		visit.add(new Node(begin,"",1));
		vi.add(begin);
		que.add(new Node(begin,"",1));
		while(!que.isEmpty()){
			Node node =que.poll();
			int num = node.word.length();
			for(int i=0;i<num;++i){
				String nextWord = node.word;
				for(int j=0;j<26;++j){
					StringBuilder temp = new StringBuilder(nextWord);
					temp.setCharAt(i,(char)('a'+j));
					nextWord = temp.toString();
					if(nextWord!=node.word){
						if(nextWord.equals(end)){
							visit.add(new Node(end,node.word,node.distance+1));
							return visit;
						}
						if ((wordDict.contains(nextWord)) && (!vi.contains(nextWord))) {
							wordDict.remove(nextWord);
							que.add(new Node(nextWord,node.word,node.distance+1));
							visit.add(new Node(nextWord,node.word,node.distance+1));
							vi.add(nextWord);
						}
					}
				}
			}
		}
		ArrayList<Node> A= new ArrayList<Node>();
		return A;
	}
	public static String printpath(ArrayList<Node>visit,String begin,String end){
		ArrayList<String> path = new ArrayList<String>();
		if(visit.size()==0){
			return "Sorry,there isn't a way between two words";
		}
		int num = visit.size();
		Node  node = visit.get(num-1);
		path.add(node.word);
		String pre = node.preWord;
		int dis = node.distance;
		for(int i=num-2;i>=0;--i){
			Node node1 = visit.get(i);
			if(node1.distance ==dis-1 && node1.word ==pre){
				pre = node1.preWord;
				--dis;
				path.add(node1.word);
			}
		}
		num = path.size();
		String result="";
		if((!path.get(0).equals(end))||(! path.get(num-1).equals(begin))){
			return "Sorry,there isn't a way between two words";
		}
		for(int i=num-1;i>=1;--i){
			result+=(path.get(i)+"->");
		}
		result+=path.get(0);
		return result;
	}
	public static Set<String> Read(String filename)throws IOException {
		Set<String> wordDict = new HashSet<String>();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		fis = new FileInputStream(filename);
		isr = new InputStreamReader(fis);
		br = new BufferedReader(isr);
		String str="";
		str = br.readLine();
		while(str !=null ){
			str = br.readLine();
			wordDict.add(str);
		}
		br.close();
		return wordDict;
	}
	@RequestMapping("/test")
	@ResponseBody
	public  String demo() {
		try{
			String filename ="C:\\Users\\hp\\Desktop\\dictionary.txt";
			Set<String> wordDict = Read(filename);
			String begin = "hate";
			String end = "data";
			ArrayList<Node> visit= bfs(begin,end,wordDict);
			String result = printpath(visit,begin,end);
			return result;
		}
		catch(IOException e){
			System.out.println("No find the dictionary!");
			return "No find the dictionary!";
		}
	}
}



