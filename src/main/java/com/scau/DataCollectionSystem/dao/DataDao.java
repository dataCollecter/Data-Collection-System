package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.Data;

import java.util.List;

public interface DataDao extends MongoBase<Data>{

    public List<Data> getData();

    public List<Data> getData(int skip, int limit);

    public List<Data> queryData(String[] key, String[] value, int length);

    public List<Data> queryData(String[] key, String[] value, int length, int skip, int limit);
}
