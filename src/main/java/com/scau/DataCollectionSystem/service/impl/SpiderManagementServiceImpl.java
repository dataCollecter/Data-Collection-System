package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.SpiderDao;
import com.scau.DataCollectionSystem.entity.Spider;
import com.scau.DataCollectionSystem.service.SpiderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@Service
public class SpiderManagementServiceImpl implements SpiderManagementService {

    @Autowired
    private SpiderDao spiderDao;

    public SpiderManagementServiceImpl() {

    }

    public List<Spider> getSpiderList() {
        return spiderDao.findAll(Spider.class);
    }

    public void removeSpider(String name) {
        spiderDao.remove(new Query(Criteria.where("name").is(name)), Spider.class);
    }

    public boolean createSpider(String name, String url, String title1, String date1, String title2, String date2) throws IOException {
        Spider spider = new Spider(name, url, title1, date1, title2, date2);
        spiderDao.insert(spider);
        String shpath="/start_spider/"+name+".sh";
        String timing_path="/var/spool/cron/crontabs/hadoop";
        String body="cd /datacollecter\nscrapy crawl spider -q spider_name="+name+"\n";
        try {
            FileWriter fileWriter=new FileWriter(shpath);
            fileWriter.write(body);
            fileWriter.close();
            fileWriter=new FileWriter(timing_path,true);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.println("0 5 0/1 * *"+shpath);//暂定
            printWriter.flush();
            fileWriter.flush();
            printWriter.close();
            fileWriter.close();
            Runtime.getRuntime().exec(shpath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

}
