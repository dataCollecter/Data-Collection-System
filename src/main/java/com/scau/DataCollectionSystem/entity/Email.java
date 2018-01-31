package com.scau.DataCollectionSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 哲帆 on 2018.1.28.
 */
@Document(collection = "email")
public class Email {

    @Field
    private String address;

    @Field
    private String name;

    @Field
    private boolean enable;

    public Email() {
    }

    public Email(String address, String name, boolean enable) {
        this.address = address;
        this.name = name;
        this.enable = enable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}