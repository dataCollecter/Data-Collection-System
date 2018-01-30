package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.User;

public interface UserDao extends MongoBase<User>{

    public User verifyLogin(String password);

}
