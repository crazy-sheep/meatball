package com.demo.meatball.controller;

import com.demo.meatball.common.response.RespResult;
import com.demo.meatball.po.UserInfo;
import com.demo.meatball.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xxx
 */
@RestController
@Api
public class LoginController {
    @Resource
    private LoginService loginService;
    
    @PostMapping("/login")
    private RespResult login(@RequestBody  @Validated UserInfo user){
       return loginService.login(user);
    }
    
}
