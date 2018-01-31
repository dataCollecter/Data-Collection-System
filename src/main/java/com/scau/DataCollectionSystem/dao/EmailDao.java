package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.Email;

public interface EmailDao extends MongoBase<Email>{

    public Email findContact(String name);

    public void deleteContact(String name);

}
