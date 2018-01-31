package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.impl.EmailDaoImpl;
import com.scau.DataCollectionSystem.entity.Email;
import com.scau.DataCollectionSystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private EmailDaoImpl emailDao;

    @Override
    public List<Email> getContacts() {
        List<Email> resList = emailDao.findAll(Email.class);
        return resList;
    }

    @Override
    public boolean addContact(Email newEmail) {
        //查重
        if(emailDao.findContact(newEmail.getName()) != null)
            return false;

        newEmail.setEnable(true);
        emailDao.insert(newEmail);

        return true;
    }

    @Override
    public boolean deleteContact(String name) {
        //判断联系人是否存在
        if(emailDao.findContact(name) == null)
            return false;

        emailDao.deleteContact(name);
        return true;
    }


}
