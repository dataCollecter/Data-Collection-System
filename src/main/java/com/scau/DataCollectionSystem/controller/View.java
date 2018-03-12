package com.scau.DataCollectionSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/view")
public class View {

    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value="/redirect")
    public String redirect(){
        return "redirect";
    }

}
