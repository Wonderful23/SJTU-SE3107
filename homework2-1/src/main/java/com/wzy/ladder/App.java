package com.wzy.ladder;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;
public class App{
	public static ArrayList<Node> bfs(String begin,String end,Set<String>wordDict){
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
	public static String printpath(ArrayList<Node> temp1,String begin,String end){
		ArrayList<String> path = new ArrayList<String>();
		if(temp1.size()==0){
			return "Sorry,there isn't a way between two words";
		}
		int num = temp1.size();
		Node  node = temp1.get(num-1);
		path.add(node.word);
		String pre = node.preWord;
		int dis = node.distance;
		for(int i=num-2;i>=0;--i){
			Node node1 = temp1.get(i);
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
	public static Set<String> Read(String filename)throws IOException{
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
	public static void run(){
		try{
			String filename ="C:\\Users\\hp\\Desktop\\wordLadder\\src\\dictionary.txt";
			Set<String> wordDict = Read(filename);
			System.out.println("Wordladder Begin:");
			Scanner sc = new Scanner(System.in);
            String begin = sc.nextLine();
            System.out.println("Wordladder End:");
            String end = sc.nextLine();
			ArrayList<Node> visit= bfs(begin,end,wordDict);
			String result = printpath(visit,begin,end);
			System.out.println(result);
			sc.close();
		}
		catch(IOException e){
			System.out.println("No find the dictionary!");
		}
	}
	public static void main(String[]args){
			run();
    }
}


