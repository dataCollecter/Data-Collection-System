package com.scau.DataCollectionSystem.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 哲帆 on 2018.1.28.
 */
@Document(collection = "follow_path")
public class FollowPath {

    @Field
    private String spider_name;

    @Field
    private String path_a;

    @Field
    private String path_all;

    @Field
    private String path_date;

    @Field
    private String path_tot;

    @Field
    private String url;

    public FollowPath(String spider_name, String url, String path_a, String path_all, String path_date, String path_tot) {
        this.spider_name = spider_name;
        this.url = url;
        this.path_a=path_a;
        this.path_all=path_all;
        this.path_date=path_date;
        this.path_tot=path_tot;
    }

    public String getSpider_name() {
        return spider_name;
    }

    public void setSpider_name(String name) {
        this.spider_name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath_a() {
        return path_a;
    }

    public void setPath_a(String path_a) {
        this.path_a = path_a;
    }

    public String getPath_all() {
        return path_all;
    }

    public void setPath_all(String path_all) {
        this.path_all = path_all;
    }

    public String getPath_date() {
        return path_date;
    }

    public void setPath_date(String path_date) {
        this.path_date = path_date;
    }

    public String getPath_tot() {
        return path_tot;
    }

    public void setPath_tot(String path_tot) {
        this.path_tot = path_tot;
    }
}
