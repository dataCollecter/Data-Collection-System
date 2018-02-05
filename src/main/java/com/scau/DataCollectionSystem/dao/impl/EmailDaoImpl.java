package com.scau.DataCollectionSystem.dao.impl;

import com.scau.DataCollectionSystem.dao.EmailDao;
import com.scau.DataCollectionSystem.entity.Email;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailDaoImpl extends MongoBaseImpl<Email> implements EmailDao {

    @Override
    public List<Email> getContactList(int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "_id"));
        query.skip(skip).limit(limit);
        return this.find(query, Email.class);
    }

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