package com.scau.DataCollectionSystem.controller;

import com.scau.DataCollectionSystem.entity.Data;
import com.scau.DataCollectionSystem.service.DataService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public JSONObject getData(@RequestBody JSONObject json) {
        int limit = json.getInt("pageSize");
        int skip = (json.getInt("pageNum") - 1) * limit;

        List<Data> data = dataService.getData(skip, limit);

        JSONArray array = new JSONArray();
        for (Data aData : data) {
            JSONObject obj = new JSONObject();
            obj.put("source", aData.getSpider());
            obj.put("time", aData.getDate());
            obj.put("title", aData.getTitle());
            obj.put("url", aData.getUrl());

            array.add(obj);
        }
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public JSONObject queryData(@RequestBody JSONObject json) {
        int limit = json.getInt("pageSize");
        int skip = (json.getInt("pageNum")-1) * limit;
        String[] info = new String[3];
        info[0] = json.getString("source");
        info[1] = json.getString("time");
        info[2] = json.getString("key");

        List<Data> data = dataService.queryData(info, skip, limit);

        JSONArray array = new JSONArray();
        for (Data aData : data) {
            JSONObject obj = new JSONObject();
            obj.put("source", aData.getSpider());
            obj.put("time", aData.getDate());
            obj.put("title", aData.getTitle());
            obj.put("url", aData.getUrl());

            array.add(obj);
        }
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

}
