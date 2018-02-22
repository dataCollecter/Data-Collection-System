package com.scau.DataCollectionSystem.service;

import com.scau.DataCollectionSystem.entity.Email;

import java.util.List;

public interface ContactService {

    /**
     * 获取联系人列表
     * @return
     */
    public List<Email> getAlllContacts();

    /**
     * 获取联系人列表
     * @return
     */
    public List<Email> getContacts(int skip, int limit);

    /**
     * 添加联系人
     * @param newEmail
     * @return  执行结果
     */
    public boolean addContact(Email newEmail);

    /**
     * 删除联系人
     * @param name  要删除的联系人
     * @return  删除结果
     */
    public boolean deleteContact(String name);
}
