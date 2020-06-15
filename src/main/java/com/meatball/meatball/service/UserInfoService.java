package com.meatball.meatball.service;

import com.meatball.meatball.dao.UserInfoDao;
import com.meatball.meatball.po.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    public UserInfo findUserByName(String userName){
        return userInfoDao.findAllByUserName(userName);
    }
}
