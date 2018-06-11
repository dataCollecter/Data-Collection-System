package cn.edu.scau.DataCollectionSystem.dao;

import cn.edu.scau.DataCollectionSystem.entity.User;

public interface UserDao extends MongoBase<User>{

    public User verifyLogin(String password);

}
