package com.scau.DataCollectionSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view")
public class View {

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

}
