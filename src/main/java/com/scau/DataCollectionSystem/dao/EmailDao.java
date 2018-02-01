package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.Email;

import java.util.List;

public interface EmailDao extends MongoBase<Email>{

    public List<Email> getContactList(int skip, int limit);

    public Email findContact(String name);

    public void deleteContact(String name);

}
