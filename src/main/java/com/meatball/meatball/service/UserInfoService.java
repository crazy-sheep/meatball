package com.meatball.meatball.service;

import com.meatball.meatball.dao.UserInfoDao;
import com.meatball.meatball.po.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
