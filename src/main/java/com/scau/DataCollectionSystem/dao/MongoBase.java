package com.scau.DataCollectionSystem.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Calendar;
import java.util.List;

/**
 * Created by 哲帆 on 2018.1.28.
 */
public interface MongoBase<T> {

    long count(Query query, Class<T> entityClass);

    void insert(T object);

    T findOne(Query query, Class<T> entityClass);

    List<T> find(Query query, Class<T> entityClass);

    List<T> findAll(Class<T> entityClass);

    void updateFirst(Query query, Update update,Class<T> entityClass);

    void updateMulti(Query query, Update update,Class<T> entityClass);

    void remove(Query query,Class<T> entityClass);

}
