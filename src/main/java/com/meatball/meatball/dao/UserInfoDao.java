package com.meatball.meatball.dao;

import com.meatball.meatball.po.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo,Long> {
    UserInfo findAllByUserName(String userName);
}
