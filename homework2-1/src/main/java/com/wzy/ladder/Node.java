package com.wzy.ladder;

public class Node{
    String word,preWord;
    int distance;
    public Node(String w,String p,int d){
        word =w;
        preWord = p;
        distance= d;
    }
}