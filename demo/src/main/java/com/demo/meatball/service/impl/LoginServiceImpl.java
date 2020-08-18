package com.demo.meatball.service.impl;

import com.demo.meatball.common.response.RespResult;
import com.demo.meatball.common.response.ResultEnum;
import com.demo.meatball.common.response.ResultUtil;
import com.demo.meatball.dao.UserInfoDao;
import com.demo.meatball.po.UserInfo;
import com.demo.meatball.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xxx
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public RespResult login(UserInfo user) {
        UserInfo userInfo = userInfoDao.findAllByUserName(user.getUserName());
        if (userInfo == null){
            return ResultUtil.error(300,"用户名不存在");
        }else {
         return ResultUtil.success(userInfo);
        }
    }
}
