package cn.edu.scau.DataCollectionSystem.dao.impl;

import cn.edu.scau.DataCollectionSystem.dao.DataDao;
import cn.edu.scau.DataCollectionSystem.entity.Data;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataDaoImpl extends MongoBaseImpl<Data> implements DataDao {

    @Override
    public List<Data> getData() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "date"));

        return this.find(query, Data.class);
    }

    @Override
    public List<Data> getData(int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "date"));
        query.skip(skip).limit(limit);

        return this.find(query, Data.class);
    }

    @Override
    public long getCount() {
        return this.count(new Query(), Data.class);
    }

    @Override
    public List<Data> queryData(String key, int skip, int limit) {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "date"));
        query.addCriteria(new Criteria().orOperator(
                Criteria.where("spider").regex(".*" + key + ".*"),
                Criteria.where("title").regex(".*" + key + ".*"),
                Criteria.where("date").regex(".*" + key + ".*")
        ));
//        query.addCriteria(Criteria.where("spider").regex(".*" + key + ".*")
//                        .orOperator(Criteria.where("title").regex(".*" + key + ".*")
//                                .orOperator(Criteria.where("date").regex(".*" + key + ".*"))));
        return this.find(query, Data.class);
    }

    @Deprecated
    @Override
    public List<Data> queryData(String[] key, String[] value,int length) {

        Query query = new Query();

        query.with(new Sort(Sort.Direction.DESC, "date"));

        getQuery(key, value, length, query);
        return this.find(query, Data.class);
    }

    @Deprecated
    @Override
    public List<Data> queryData(String[] key, String[] value,int length, int skip, int limit) {

        Query query = new Query();

        query.with(new Sort(Sort.Direction.DESC, "date"));
        query.skip(skip).limit(limit);

        getQuery(key, value, length, query);
        return this.find(query, Data.class);
    }

    private void getQuery(String[] key, String[] value, int length, Query query) {
        switch (length)
        {
            case 1:query.addCriteria(new Criteria(key[0]).is(value[0]));
                break;
            case 2:query.addCriteria(Criteria.where(key[0]).is(value[0]).and(key[1]).is(value[1]));
                break;
            case 3:query.addCriteria(Criteria.where(key[0]).is(value[0]).and(key[1]).is(value[1]).and(key[2]).is(value[2]));
                break;
        }
    }
}
