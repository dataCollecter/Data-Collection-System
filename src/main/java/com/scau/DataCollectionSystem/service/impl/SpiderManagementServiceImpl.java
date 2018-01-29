package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.MongoBase;
import com.scau.DataCollectionSystem.entity.Spider;
import com.scau.DataCollectionSystem.service.SpiderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@Service
public class SpiderManagementServiceImpl implements SpiderManagementService {

    @Autowired
    private MongoBase<Spider> spiderMongoBase;

    public SpiderManagementServiceImpl(){

    }

    public List<Spider> getSpiderList() {
        return spiderMongoBase.findAll(Spider.class);
    }

}
