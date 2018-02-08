package com.scau.DataCollectionSystem.controller;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/out")
    public String output()
    {
        System.out.println( "good");

        return "login";
    }
}
