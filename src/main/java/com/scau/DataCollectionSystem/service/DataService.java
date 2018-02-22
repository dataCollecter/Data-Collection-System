package com.scau.DataCollectionSystem.service;

import com.scau.DataCollectionSystem.entity.Data;

import java.util.List;

public interface DataService {

    public List<Data> getData(int skip, int limit);

    public List<Data> getAllData();

    public List<Data> queryData(String[] info, int skip, int limit);

    public List<Data> queryData(String[] info);
}
