package com.example.nosecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class LoginController {
    @RequestMapping("/user-login")
    public String index(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if(!"user".equals(username)){
            model.addAttribute("msg","Wrong password oe username");
            return "login";
        }
        System.out.println(username);
        return "login-success";
    }
    // Login form
    @RequestMapping("/login-success")
    public String loginsuccess() {
        return "login-success";
    }
    @RequestMapping("/")
    public String Main() {
        return "main";
    }
    @RequestMapping("/login")//http://localhost:8080/login
    public String login() {
        return "login";
    }
    // Login form with error

}
