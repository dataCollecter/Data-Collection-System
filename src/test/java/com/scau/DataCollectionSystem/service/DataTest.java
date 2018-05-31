package com.scau.DataCollectionSystem.service;

import com.scau.DataCollectionSystem.entity.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DataTest {

    @Autowired
    private DataService dataService;

    @Test
    public void getTest()
    {
        int limit = 2;
        int skip = 0;
        String[] info = new String[3];
        info[0] = "wows";
        info[1] = "2018-2-4";
        info[2] = "hsf";

        List<Data> data = dataService.queryData(info, skip, limit);

        System.out.println(data.size());
        for(int i=0; i<data.size(); ++i)
        {
            System.out.println(data.get(i).getSpider() + "  " + data.get(i).getDate() + "  " + data.get(i).getTitle()
                + "  " + data.get(i).getUrl());
        }
    }

    @Test
    public void test() throws IOException {
        String s="/root/start_spider/"+"a"+".sh";
        String d="/root/start_spider/\n"+"/root/start_spider/"+"a"+".sh\n"+"/root/start_spider/\n";
        BufferedReader br=new BufferedReader(new StringReader(d));
        Pattern pattern=Pattern.compile(s);
        Matcher matcher;
        String temp;
        while((temp=br.readLine())!=null){
            matcher=pattern.matcher(temp);
            System.out.println(matcher.find());
            if(matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }

}
