package com.scau.DataCollectionSystem.service;

import com.scau.DataCollectionSystem.entity.Data;

import java.util.List;

public interface DataService {
    List<Data> dataRequireHandler(int skip, int limit, String query);

    long getDataCount();

    List<Data> getData(int skip, int limit);

    @Deprecated
    List<Data> getAllData();

    @Deprecated
    List<Data> queryData(String[] info, int skip, int limit);

    @Deprecated
    List<Data> queryData(String[] info);
}
