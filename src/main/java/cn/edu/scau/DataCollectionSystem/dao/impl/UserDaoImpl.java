package cn.edu.scau.DataCollectionSystem.dao.impl;

import cn.edu.scau.DataCollectionSystem.entity.User;
import cn.edu.scau.DataCollectionSystem.dao.UserDao;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends MongoBaseImpl<User> implements UserDao{

    @Override
    public User verifyLogin(String password) {
        Query query = new Query();
        query.addCriteria(new Criteria("password").is(password));
        return this.findOne(query, User.class);
    }
}
