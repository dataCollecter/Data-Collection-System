package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.Data;

import java.util.List;

public interface DataDao extends MongoBase<Data>{

    List<Data> getData();

    List<Data> getData(int skip, int limit);

    List<Data> queryData(String key, int skip, int limit);

    long getCount();

    @Deprecated
    List<Data> queryData(String[] key, String[] value, int length);

    @Deprecated
    List<Data> queryData(String[] key, String[] value, int length, int skip, int limit);
}
