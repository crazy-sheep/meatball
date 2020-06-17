package com.demo.meatball.service;

import com.demo.meatball.dao.UserInfoDao;
import com.demo.meatball.po.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    private final UserInfoDao userInfoDao;

    public UserInfoService(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public UserInfo findUserByName(String userName){
        return userInfoDao.findAllByUserName(userName);
    }

    public List<UserInfo> findAll(){
        return userInfoDao.findAll();
    }

    public UserInfo saveUser(UserInfo user){
        return userInfoDao.save(user);
    }

    public UserInfo updateUser(UserInfo user){
        return userInfoDao.saveAndFlush(user);
    }

    public void deleteUser(long id){
        userInfoDao.deleteById(id);
    }
}
