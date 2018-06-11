package cn.edu.scau.DataCollectionSystem.service;

import java.util.List;

import cn.edu.scau.DataCollectionSystem.entity.Spider;

/**
 * Created by 哲帆 on 2018.1.29.
 */
public interface SpiderManagementService {

    List<Spider> getSpiderList(int skip, int limit);

    boolean removeSpider(String name);

    boolean createSpider(String name, String url, String title1, String date1, String title2, String date2);

}
