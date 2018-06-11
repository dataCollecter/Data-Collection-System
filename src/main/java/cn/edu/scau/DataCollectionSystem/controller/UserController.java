package cn.edu.scau.DataCollectionSystem.controller;

import cn.edu.scau.DataCollectionSystem.service.UserService;
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
    public JSONObject login(@RequestBody JSONObject json, HttpSession session)
    {
        String password = json.getString("password");

        JSONObject res = new JSONObject();
        if(userService.login(password))
        {
            res.put("code", 10);
            session.setAttribute("user", System.currentTimeMillis());
        }
        else
            res.put("code", 11);

        return res;
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpSession session)
    {
        System.out.println("clear session");
        session.removeAttribute("user");
    }

}
