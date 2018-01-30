package com.scau.DataCollectionSystem.dao.impl;

import com.scau.DataCollectionSystem.dao.UserDao;
import com.scau.DataCollectionSystem.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends MongoBaseImpl<User> implements UserDao{

    @Override
    public User verifyLogin(String password) {
        Query query = new Query();
        query.addCriteria(new Criteria("password").is(password));
        return this.mongoTemplate.findOne(query, User.class);
    }
}
