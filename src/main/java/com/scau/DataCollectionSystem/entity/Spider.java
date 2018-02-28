package com.scau.DataCollectionSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 哲帆 on 2018.1.28.
 */
@Document(collection = "Spider")
public class Spider {

    @Field
    private String name;

    @Field
    private String url;

    @Field
    private String createDate;

    @Field
    private String title1;

    @Field
    private String date1;

    @Field
    private String title2;

    @Field
    private String date2;

    public Spider(String name, String url, String createDate, String title1, String date1, String title2, String date2) {
        this.name = name;
        this.url = url;
        this.createDate = createDate;
        this.title1 = title1;
        this.date1 = date1;
        this.title2 = title2;
        this.date2 = date2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
}
