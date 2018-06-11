package cn.edu.scau.DataCollectionSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value="/error")
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/interceptor", method = RequestMethod.GET)
    public String interceptor(@RequestParam(value = "code", defaultValue = "") String passCode, HttpSession session) {
        return "redirect:/view/index";
    }

}
