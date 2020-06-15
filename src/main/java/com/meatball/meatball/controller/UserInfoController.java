package com.meatball.meatball.controller;

import com.meatball.meatball.po.UserInfo;
import com.meatball.meatball.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/userName/{userName}")
    public UserInfo getUser(@PathVariable("userName")String userName){
        return userInfoService.findUserByName(userName);
    }
}
