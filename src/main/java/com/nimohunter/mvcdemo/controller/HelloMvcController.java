package com.nimohunter.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/")
public class HelloMvcController {

    @RequestMapping("/")
    public String helloMvc() {

        return "home";
    }

}
