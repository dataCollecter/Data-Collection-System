package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.Spider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 哲帆 on 2018.1.29.
 */
@Repository
public interface SpiderDao extends MongoBase<Spider> {

    List<Spider> getSpiderList();

    Spider findSpider(String name);

    void removeSpider(String name);

}
