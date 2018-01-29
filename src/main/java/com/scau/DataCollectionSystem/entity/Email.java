package com.scau.DataCollectionSystem.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 哲帆 on 2018.1.28.
 */
@Document(collection = "Email")
public class Email {

    @Id
    private String id;

    @Field
    private String address;

    @Field
    private String name;

    @Field
    private boolean enable;

}
