package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Set;

import static com.example.demo.wordladderController.*;

@Controller
@RestController
public class HelloController{
    @Autowired login login;
    @Autowired
    public HttpServletRequest servletRequest;
    @GetMapping("/login2/{username}/{password}/{begin}/{end}")
    public String login(@PathVariable("username")String username, @PathVariable("password")String password,@PathVariable("begin")String begin,@PathVariable("end")String end,  HttpServletResponse response){
        String temp = login.productMsg(username,password);
        if(temp.equals("1")){
            try{
                String filename ="C:\\Users\\hp\\Desktop\\dictionary.txt";
                Set<String> wordDict = Read(filename);
                System.out.println("ok,here");
                ArrayList<Node> visit= bfs(begin,end,wordDict);
                String result = printpath(visit,begin,end);
                System.out.println(result);
                return result;
            }
            catch(Exception e){
                System.out.println("No find the dictionary!");
                String result = "No find the dictionary!";
                return result;
            }
        }
        else{
            return"username and password is failed!";
        }
    }
    @RequestMapping("/templates")
    public ModelAndView demo(HttpServletRequest request, HttpServletResponse response) {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        try{
            String filename ="C:/Users/hp/Desktop/dictionary.txt";
            Set<String> wordDict = Read(filename);
            ArrayList<Node> visit= bfs(begin,end,wordDict);
            String result = printpath(visit,begin,end);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("begin", begin);
            modelAndView.addObject("end", end);
            modelAndView.addObject("result", result);
            //System.out.println("test");
            return modelAndView;
        }
        catch(Exception e){
            System.out.println("No find the dictionary!");
            ModelAndView modelAndView = new ModelAndView();
            String result = "No find the dictionary!";
            modelAndView.setViewName("templates/demo.html");
            modelAndView.addObject("begin", begin);
            modelAndView.addObject("end", end);
            modelAndView.addObject("result", result);
            //System.out.println("test");
            return modelAndView;
        }
    }
}
