package com.scau.DataCollectionSystem.service;

import com.scau.DataCollectionSystem.entity.Spider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * Created by 哲帆 on 2018.1.30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class spiderServiceTest {

    @Autowired
    private SpiderManagementService spiderManagementService;

    @Test
    public void Test() throws IOException {
        spiderManagementService.createSpider("a","1","1","1","1","2");
        List<Spider> spiderList=spiderManagementService.getSpiderList();
        System.out.println(spiderList.size());
        System.out.println(spiderList.get(0).getName());
        spiderManagementService.removeSpider("a");
    }

}
