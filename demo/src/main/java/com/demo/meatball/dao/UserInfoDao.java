package com.demo.meatball.dao;


import com.demo.meatball.po.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo,Long> {
    UserInfo findAllByUserName(String userName);
}
