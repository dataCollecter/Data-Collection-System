package cn.edu.scau.DataCollectionSystem.service.impl;

import cn.edu.scau.DataCollectionSystem.dao.impl.DataDaoImpl;
import cn.edu.scau.DataCollectionSystem.entity.Data;
import cn.edu.scau.DataCollectionSystem.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDaoImpl dataDao;

    @Override
    public List<Data> dataRequireHandler(int skip, int limit, String query) {
        if(query.isEmpty())
            return getData(skip, limit);
        return queryData(skip, limit, query);
    }

    @Override
    public List<Data> getData(int skip, int limit) {
        return dataDao.getData(skip, limit);
    }

    @Override
    @Deprecated
    public List<Data> getAllData() {
        return dataDao.getData();
    }

    private List<Data> queryData(int skip, int limit, String query) {
        return dataDao.queryData(query, skip, limit);
    }

    @Override
    public long getDataCount() {
        return dataDao.getCount();
    }

    @Override
    @Deprecated
    public List<Data> queryData(String[] info, int skip, int limit) {

        String[] key = new String[3];
        String[] value = new String[3];
        int count = 0;

        if (!info[0].trim().equals("")) {
            key[count] = "spider";
            value[count++] = info[0];
        }
        if (!info[1].trim().equals("")) {
            key[count] = "date";
            value[count++] = info[1];
        }
        if (!info[2].trim().equals("")) {
            key[count] = "title";
            value[count++] = info[2];
        }

        return dataDao.queryData(key, value, count, skip, limit);
    }

    @Override
    @Deprecated
    public List<Data> queryData(String[] info) {

        String[] key = new String[3];
        String[] value = new String[3];
        int count = 0;

        if (!info[0].trim().equals("")) {
            key[count] = "spider";
            value[count++] = info[0];
        }
        if (!info[1].trim().equals("")) {
            key[count] = "date";
            value[count++] = info[1];
        }
        if (!info[2].trim().equals("")) {
            key[count] = "title";
            value[count++] = info[2];
        }

        return dataDao.queryData(key, value, count);
    }

}
