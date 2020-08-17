package com.demo.meatball.service.impl;

import com.demo.meatball.common.response.RespResult;
import com.demo.meatball.common.response.ResultUtil;
import com.demo.meatball.po.UserInfo;
import com.demo.meatball.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author xxx
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public RespResult login(UserInfo user) {
        return ResultUtil.success(null);
    }
}
