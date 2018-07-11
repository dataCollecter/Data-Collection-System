package cn.edu.scau.DataCollectionSystem.controller;

import cn.edu.scau.DataCollectionSystem.entity.Data;
import cn.edu.scau.DataCollectionSystem.service.DataService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public JSONObject getData(HttpServletRequest request) {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int limit = Integer.parseInt(request.getParameter("length"));
        int skip = Integer.parseInt(request.getParameter("start"));
        String query = request.getParameter("search[value]");

        JSONArray array = new JSONArray();
        int filter = buildResult(   //这个值暂且没用
                dataService.dataRequireHandler(skip, limit, query), array);
        long count = dataService.getDataCount();

        JSONObject res = new JSONObject();
        res.put("draw", draw);
        res.put("recordsTotal", count);
        res.put("recordsFiltered", count);  //filter);
        res.put("data", array);
        return res;
    }

    @Deprecated
    @RequestMapping(value = "/query")
    @ResponseBody
    public JSONObject queryData(@RequestBody JSONObject json) {
        int limit = json.getInt("pageSize");
        int skip = (json.getInt("pageNum")-1) * limit;

        String[] info = new String[3];
        info[0] = json.getString("source");
        info[1] = json.getString("time");
        info[2] = json.getString("key");

        JSONArray array = new JSONArray();
        buildResult(dataService.queryData(info, skip, limit), array);
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

    private int buildResult(List<Data> data, JSONArray array) {
        for (Data aData : data) {
            JSONObject obj = new JSONObject();
            obj.put("source", aData.getSpider());
            obj.put("time", aData.getDate());
            obj.put("title", aData.getTitle());
            obj.put("url", aData.getUrl());

            array.add(obj);
        }
        return data.size();
    }

}


/*
        System.out.println(json);
        int draw = json.getInt("draw");
        int limit = json.getInt("pageSize");
        int skip = (json.getInt("pageNum") - 1) * limit;
//        String query = json.getString("")

        JSONArray array = buildResult(dataService.getData(skip, limit));
        JSONObject res = new JSONObject();
        res.put("draw", draw);
        res.put("recordsTotal", 1);
        res.put("recordsFiltered", 1);
        res.put("result", array);
        return res;
 */