package com.scau.DataCollectionSystem.dao.impl;

import com.scau.DataCollectionSystem.dao.FollowPathDao;
import com.scau.DataCollectionSystem.dao.MongoBase;
import com.scau.DataCollectionSystem.entity.FollowPath;
import com.scau.DataCollectionSystem.entity.Spider;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 哲帆 on 2018.5.31.
 */
@Repository
public class FollowPathDaoImpl extends MongoBaseImpl<FollowPath> implements FollowPathDao {
    /**
     * @param spiderName
     */
    @Override
    public void removeFollowPath(String spiderName) {
        Query query = new Query();
        query.addCriteria(new Criteria("spider_name").is(spiderName));
        this.remove(query, FollowPath.class);
    }
}
