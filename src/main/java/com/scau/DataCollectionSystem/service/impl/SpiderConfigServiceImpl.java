package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.SpiderDao;
import com.scau.DataCollectionSystem.service.SpiderConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
/**
 * Created by 哲帆 on 2018.1.29.
 */
@Service
public class SpiderConfigServiceImpl implements SpiderConfigService {

    @Autowired
    private SpiderDao spiderDao;

    public boolean createSpider(String spider_name, String title1, String date1, String title2, String date2) {
        try{
            Query query=new Query();
            query.addCriteria(Criteria.where("spider_name").is(spider_name));
            Update update=new Update();
            update.addToSet("title1",title1);
            update.addToSet("date1",date1);
            update.addToSet("title2",title1);
            update.addToSet("date2",date2);
            spiderDao.updateFirst(query,update,"spider");
        }catch (Exception e){
            throw e;
        }
        return true;
    }
}
