package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.impl.UserDaoImpl;
import com.scau.DataCollectionSystem.entity.User;
import com.scau.DataCollectionSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public boolean login(String password) {

        User res = userDao.verifyLogin(password);

        if(res != null)
            return  true;

        return false;
    }
}
