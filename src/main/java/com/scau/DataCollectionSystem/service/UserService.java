package com.scau.DataCollectionSystem.service;

public interface UserService {

    /**
     * 登陆系统
     * @param password  口令
     * @return  登录成功/失败
     */
    public boolean login(String password);
}
