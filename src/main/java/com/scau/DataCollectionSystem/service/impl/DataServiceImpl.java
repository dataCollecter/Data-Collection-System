package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.impl.DataDaoImpl;
import com.scau.DataCollectionSystem.entity.Data;
import com.scau.DataCollectionSystem.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDaoImpl dataDao;

    @Override
    public List<Data> getData(int skip, int limit) {
        List<Data> resList = dataDao.getData(skip, limit);
        return resList;
    }

    @Override
    public List<Data> getAllData() {
        List<Data> resList = dataDao.getData();
        return resList;
    }

    @Override
    public List<Data> queryData(String[] info, int skip, int limit) {

        String[] key = new String[3];
        String[] value = new String[3];
        int count = 0;

        if(!info[0].trim().equals(""))
        {
            key[count] = "spider";
            value[count++] = info[0];
        }
        if(!info[1].trim().equals(""))
        {
            key[count] = "date";
            value[count++] = info[1];
        }
        if(!info[2].trim().equals(""))
        {
            key[count] = "title";
            value[count++] = info[2];
        }

        List<Data> resList = dataDao.queryData(key, value, count, skip, limit);

        return resList;
    }

    @Override
    public List<Data> queryData(String[] info) {

        String[] key = new String[3];
        String[] value = new String[3];
        int count = 0;

        if(!info[0].trim().equals(""))
        {
            key[count] = "spider";
            value[count++] = info[0];
        }
        if(!info[1].trim().equals(""))
        {
            key[count] = "date";
            value[count++] = info[1];
        }
        if(!info[2].trim().equals(""))
        {
            key[count] = "title";
            value[count++] = info[2];
        }

        List<Data> resList = dataDao.queryData(key, value, count);

        return resList;
    }
}
