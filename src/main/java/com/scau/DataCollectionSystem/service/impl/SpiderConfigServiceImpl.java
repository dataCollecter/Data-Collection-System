package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.MongoBase;
import com.scau.DataCollectionSystem.dao.SpiderDao;
import com.scau.DataCollectionSystem.entity.Spider;
import com.scau.DataCollectionSystem.service.SpiderConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@Service
public class SpiderConfigServiceImpl implements SpiderConfigService {

    @Autowired
    private SpiderDao spiderDao;

    public boolean createSpider(String name, String title1, String date1, String title2, String date2) {
        return false;
    }
}
