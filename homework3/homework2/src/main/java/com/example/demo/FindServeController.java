package com.example.demo;

import com.netflix.client.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Controller
@RestController
public class FindServeController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String ip;
    @PostMapping ("/login")
    public String client(@RequestParam("username")String username,@RequestParam("password")String password){
        if(username.equals("test")&&password.equals("123456"))
        return "1";
        else
            return "0";
    }
}
