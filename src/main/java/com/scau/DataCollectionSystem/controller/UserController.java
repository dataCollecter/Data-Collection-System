package com.scau.DataCollectionSystem.controller;

import com.scau.DataCollectionSystem.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject json, HttpSession seeion)
    {
        String password = json.getString("password");

        JSONObject res = new JSONObject();

        if(userService.login(password))
        {
            res.put("code", 10);
        }
        else
            res.put("code", 11);

        return res;

    }

}