package cn.edu.scau.DataCollectionSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by 哲帆 on 2018.1.28.
 */
@Document(collection = "Data")
public class Data {

    @Field
    private String title;

    @Field
    private String url;

    @Field
    private String spider;

    @Field
    private String date;

    public Data(String title, String url, String spider, String date) {
        this.title = title;
        this.url = url;
        this.spider = spider;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpider() {
        return spider;
    }

    public void setSpider(String spider) {
        this.spider = spider;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
