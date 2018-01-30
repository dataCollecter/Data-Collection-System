package com.scau.DataCollectionSystem.dao.impl;

import com.scau.DataCollectionSystem.dao.MongoBase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.scau.DataCollectionSystem.util.MongoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
public class MongoBaseImpl<T> implements MongoBase<T> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Autowired
    private MongoFactory mongoFactory;

    public long count(String collectionName) {
        return mongoTemplate.getCollection(collectionName).count();
    }

    public void insert(T object, String collectionName) {
        mongoTemplate.insert(object,collectionName);
    }

    public void save(T object, String collectionName) {
        mongoTemplate.save(object,collectionName);
    }

    public T findOne(Query query, Class<T> entityClass) {
        return mongoTemplate.findOne(query,entityClass);
    }

    public T findOne(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findOne(query, entityClass,collectionName);
    }

    public List<T> find(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query,entityClass);
    }

    public List<T> find(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.find(query, entityClass,collectionName);
    }

    public List<T> findAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

    public List<T> findAll(Class<T> entityClass, String collectionName) {
        return mongoTemplate.findAll(entityClass,collectionName);
    }

    public void updateFirst(Query query, Update update, String collectionName) {
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, collectionName);
        System.out.println(updateResult.toString());
    }

    public void updateMulti(Query query, Update update, String collectionName) {
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, collectionName);
        System.out.println(updateResult.toString());
    }

    public void remove(Query query, String collectionName) {
        DeleteResult remove = mongoTemplate.remove(query, collectionName);
        System.out.println(remove.toString());
    }
}
