package com.example.st.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mqx
 * @date 2020-8-25 10:38:18
 */
@Controller
public class IndexController {

    @GetMapping("index")
    @ResponseBody
    public String index(){
        return "hello index";
    }
    @GetMapping("login")
    public String login(){
        System.out.println("come on!");
        return "login";
    }
}
