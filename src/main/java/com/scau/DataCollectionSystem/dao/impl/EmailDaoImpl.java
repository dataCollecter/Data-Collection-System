package com.scau.DataCollectionSystem.dao.impl;

import com.scau.DataCollectionSystem.dao.EmailDao;
import com.scau.DataCollectionSystem.entity.Email;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDaoImpl extends MongoBaseImpl<Email> implements EmailDao {
    @Override
    public Email findContact(String name) {
        Query query = new Query();
        query.addCriteria(new Criteria("name").is(name));
        return this.findOne(query, Email.class);
    }

    @Override
    public void deleteContact(String name) {
        Query query = new Query();
        query.addCriteria(new Criteria("name").is(name));
        this.remove(query, Email.class);
    }
}
