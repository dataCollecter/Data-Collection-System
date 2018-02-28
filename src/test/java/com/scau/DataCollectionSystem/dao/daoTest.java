package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.dao.MongoBase;
import com.scau.DataCollectionSystem.dao.SpiderDao;
import com.scau.DataCollectionSystem.dao.impl.MongoBaseImpl;
import com.scau.DataCollectionSystem.entity.Spider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class daoTest {

    @Autowired
    private SpiderDao spiderDao;
    @Test
    public void Test() {
        spiderDao.remove(new Query(),Spider.class);
        Spider spider=spiderDao.findOne(new Query(Criteria.where("name").is("a")),Spider.class);
        System.out.println(spider.getName()+spider.getTitle1());
        List<Spider> spiderList=spiderDao.findAll(Spider.class);
        System.out.println(spiderList.size());
        spiderList=spiderDao.find(new Query(),Spider.class);
        System.out.println(spiderList.size());
        Update update=new Update();
        update.set("title1","4 ");
        spiderDao.updateFirst(new Query(Criteria.where("name").is("a")),update,Spider.class);
        spider=spiderDao.findOne(new Query(Criteria.where("name").is("a")),Spider.class);
        System.out.println(spider.getName()+spider.getTitle1());
        spiderDao.updateMulti(new Query(Criteria.where("url").is("2017-01-01")),update,Spider.class);
        spiderList=spiderDao.findAll(Spider.class);
        for (int i=0;i<4;i++){
            System.out.println(spiderList.get(i).getTitle1());
        }
        System.out.println(spiderDao.count(new Query(),Spider.class));
    }

}
