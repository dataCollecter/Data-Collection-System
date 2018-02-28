package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.SpiderDao;
import com.scau.DataCollectionSystem.entity.Spider;
import com.scau.DataCollectionSystem.service.SpiderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@Service
public class SpiderManagementServiceImpl implements SpiderManagementService {

    @Autowired
    private SpiderDao spiderDao;

    public List<Spider> getSpiderList() {
        return spiderDao.getSpiderList();
    }

    public boolean removeSpider(String name) {
        if(spiderDao.findSpider(name) == null)
            return false;

        spiderDao.removeSpider(name);
        return true;
    }

    public boolean createSpider(String name, String url, String title1, String date1, String title2, String date2) {

        if(spiderDao.findSpider(name) != null)
            return false;

//        String shpath="/start_spider/"+name+".sh";
//        String timing_path="/var/spool/cron/crontabs/hadoop";
//        String body="cd /datacollecter\nscrapy crawl spider -q spider_name="+name+"\n";
//        try {
//            FileWriter fileWriter=new FileWriter(shpath);
//            fileWriter.write(body);
//            fileWriter.close();
//            fileWriter=new FileWriter(timing_path,true);
//            PrintWriter printWriter=new PrintWriter(fileWriter);
//            printWriter.println("0 5 0/1 * *"+shpath);//暂定
//            printWriter.flush();
//            fileWriter.flush();
//            printWriter.close();
//            fileWriter.close();
//            Runtime.getRuntime().exec(shpath);
//        }catch (Exception e){
//            e.printStackTrace();
//            return  false;
//        }

        Date time = new Date();
        DateFormat d2 = DateFormat.getDateTimeInstance();
        String createDate = d2.format(time);
        Spider spider = new Spider(name, url, createDate, title1, date1, title2, date2);
        spiderDao.insert(spider);
        return true;
    }

}
