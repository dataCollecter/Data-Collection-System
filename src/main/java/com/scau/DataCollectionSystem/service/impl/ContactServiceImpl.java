package com.scau.DataCollectionSystem.service.impl;

import com.scau.DataCollectionSystem.dao.impl.EmailDaoImpl;
import com.scau.DataCollectionSystem.entity.Email;
import com.scau.DataCollectionSystem.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private EmailDaoImpl emailDao;

    @Override
    public List<Email> getAllContacts() {
        return emailDao.getContactList();
    }

    @Override
    public List<Email> getContacts(int skip, int limit) {
        return emailDao.getContactList(skip, limit);
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
