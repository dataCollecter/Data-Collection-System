package DataCollectionSystem.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by 哲帆 on 2018.1.28.
 */
public interface MongoBase<T> {

    long count(String collectionName);

    void insert(T object, String collectionName);

    void save(T object, String collectionName);

    T findOne(Query query, Class<T> entityClass);

    T findOne(Query query, Class<T> entityClass, String collectionName);

    List<T> find(Query query, Class<T> entityClass);

    List<T> find(Query query, Class<T> entityClass, String collectionName);

    List<T> findAll(Class<T> entityClass);

    List<T> findAll(Class<T> entityClass, String collectionName);

    void updateFirst(Query query, Update update, String collectionName);

    void updateMulti(Query query, Update update, String collectionName);

    void remove(Query query, String collectionName);

}
