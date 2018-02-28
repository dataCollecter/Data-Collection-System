package com.scau.DataCollectionSystem.controller;

import com.scau.DataCollectionSystem.entity.Email;
import com.scau.DataCollectionSystem.service.ContactService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public JSONObject getContactList(@RequestBody JSONObject json)
    {
//        int limit = json.getInt("pageSize");
//        int skip = (json.getInt("pageNum")-1) * limit;
        List<Email> contacts = contactService.getAlllContacts();

        JSONArray array = new JSONArray();
        for(int i=0; i<contacts.size(); ++i)
        {
            JSONObject obj = new JSONObject();
            obj.put("name", contacts.get(i).getName());
            obj.put("mail", contacts.get(i).getAddress());

            array.add(obj);
        }
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JSONObject addContact(@RequestBody JSONObject json)
    {
        System.out.println("add");
        Email newEmail = new Email();
        newEmail.setName(json.getString("name"));
        newEmail.setAddress(json.getString("mail"));

        JSONObject res = new JSONObject();

        if(contactService.addContact(newEmail))
            res.put("code", 10);
        else
            res.put("code", 11);

        return res;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public JSONObject deleteContact(@RequestBody JSONObject json)
    {
        JSONObject res = new JSONObject();

        if(contactService.deleteContact(json.getString("name")))
            res.put("code", 10);
        else
            res.put("code", 11);

        return res;
    }

}
