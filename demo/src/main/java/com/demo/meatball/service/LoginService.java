package com.demo.meatball.service;

import com.demo.meatball.common.response.RespResult;
import com.demo.meatball.po.UserInfo;

public interface LoginService {
    
    RespResult login(UserInfo user);
}
