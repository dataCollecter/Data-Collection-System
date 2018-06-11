package cn.edu.scau.DataCollectionSystem.service.impl;

import cn.edu.scau.DataCollectionSystem.dao.impl.UserDaoImpl;
import cn.edu.scau.DataCollectionSystem.entity.User;
import cn.edu.scau.DataCollectionSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
