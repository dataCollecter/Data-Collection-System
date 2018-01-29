package com.scau.DataCollectionSystem.service;

import java.io.IOException;
import java.util.List;

import com.scau.DataCollectionSystem.entity.Spider;

/**
 * Created by 哲帆 on 2018.1.29.
 */
public interface SpiderManagementService {

    List<Spider> getSpiderList();

    void removeSpider(String spider_name);

    boolean createSpider(String name, String title1, String date1, String title2, String date2) throws IOException;

}
