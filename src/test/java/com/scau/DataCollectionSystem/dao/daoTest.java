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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        spiderDao.insert(new Spider("a","2017-01-01","1","1","1","1"));
        Spider spider=spiderDao.findOne(new Query(Criteria.where("name").is("a")),Spider.class);
        System.out.println(spider.getName()+spider.getTitle1());
    }

}
