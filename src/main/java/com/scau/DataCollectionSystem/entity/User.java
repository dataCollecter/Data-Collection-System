package com.scau.DataCollectionSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {

    @Id
    private String id;

    @Field
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswordassword() {
        return password;
    }

    public void setPasswordassword(String password) {
        this.password = password;
    }
}
