package com.scau.DataCollectionSystem.dao.impl;

import com.scau.DataCollectionSystem.dao.SpiderDao;
import com.scau.DataCollectionSystem.entity.Spider;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@Repository
public class SpiderDaoImpl extends MongoBaseImpl<Spider> implements SpiderDao {

    @Override
    public List<Spider> getSpiderList() {
        return this.findAll(Spider.class);
    }

    @Override
    public List<Spider> getSpider(int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "createDate"));
        query.skip(skip).limit(limit);

        return this.find(query, Spider.class);
    }

    @Override
    public Spider findSpider(String name) {
        Query query = new Query();
        query.addCriteria(new Criteria("spider_name").is(name));
        return this.findOne(query, Spider.class);
    }

    @Override
    public void removeSpider(String name) {
        Query query = new Query();
        query.addCriteria(new Criteria("spider_name").is(name));
        this.remove(query, Spider.class);
    }
}
