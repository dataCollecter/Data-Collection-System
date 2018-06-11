package cn.edu.scau.DataCollectionSystem.controller;

import cn.edu.scau.DataCollectionSystem.entity.Spider;
import cn.edu.scau.DataCollectionSystem.service.SpiderManagementService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/spider")
public class SpiderController {

    @Autowired
    private SpiderManagementService spiderService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public JSONObject getSpider(@RequestBody JSONObject json) {
        int limit = json.getInt("pageSize");
        int skip = (json.getInt("pageNum") - 1) * limit;
        List<Spider> data = spiderService.getSpiderList(skip, limit);

        JSONArray array = new JSONArray();
        for (Spider aData : data) {
            JSONObject obj = new JSONObject();
            obj.put("name", aData.getSpider_name());
            obj.put("url", aData.getUrl());
            obj.put("time", aData.getCreateDate());

            array.add(obj);
        }
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public JSONObject createSpider(@RequestBody JSONObject json) {
        String name = json.getString("name");
        String url = json.getString("url");
        String title1 = json.getString("title1");
        String url1 = json.getString("url1");
        String title2 = json.getString("title2");
        String url2 = json.getString("url2");

        JSONObject res = new JSONObject();
        if (spiderService.createSpider(name, url, title1, url1, title2, url2)) {
            res.put("code", 10);
        } else
            res.put("code", 11);

        return res;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public JSONObject deleteSpider(@RequestBody JSONObject json) {
        JSONObject res = new JSONObject();

        if (spiderService.removeSpider(json.getString("name")))
            res.put("code", 10);
        else
            res.put("code", 11);

        return res;

    }
}
