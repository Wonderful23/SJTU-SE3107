package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
class User{
    public String username;
    public String password;
}
@FeignClient(name="login")
public interface login {
    @PostMapping ("/login")
    String productMsg(@RequestParam("username")String username,@RequestParam("password")String password);
}
